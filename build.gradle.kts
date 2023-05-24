import com.matthewprenger.cursegradle.CurseProject
import com.matthewprenger.cursegradle.CurseRelation
import com.matthewprenger.cursegradle.Options
import java.io.FileInputStream
import java.util.*

plugins {
    kotlin("jvm") version "1.8.21"
    id("fabric-loom") version "1.2-SNAPSHOT"
    id("com.matthewprenger.cursegradle") version "1.4.0"
    id("com.modrinth.minotaur") version "2.7.5"
}

val modVersion = "1.5.0"
val type = "release"
val props = Properties()
props.load(FileInputStream("local.properties"))

version = modVersion
group = "pl.vemu"
base.archivesName.set("diamold")


/*repositories {
    maven { url = "https://maven.fabricmc.net/" }
}*/

dependencies {
    minecraft("com.mojang:minecraft:1.19.2")
    mappings("net.fabricmc:yarn:1.19.2+build.28:v2")

    modImplementation("net.fabricmc:fabric-loader:0.14.19")

    modImplementation("net.fabricmc.fabric-api:fabric-api:0.76.0+1.19.2")
}

curseforge {
    apiKey = props.getProperty("curseforge")
    project(closureOf<CurseProject> {
        id = "415159"
        changelogType = "markdown"
        changelog = file("changelog.md")
        releaseType = type
        gameVersionStrings = listOf(
            "1.16",
            "1.16.1",
            "1.16.2",
            "1.16.3",
            "1.16.4",
            "1.16.5",
            "1.17",
            "1.17.1",
            "1.18",
            "1.18.1",
            "1.18.2",
            "1.19",
            "1.19.1",
            "1.19.2",
            "Fabric",
            "Quilt",
            "Java 17",
            "Java 11",
            "Java 8",
        )
        relations(closureOf<CurseRelation> {
            requiredDependency("fabric-api")
        })
        mainArtifact(tasks.remapJar.get())
        afterEvaluate {
            uploadTask.group = "publishing"
            uploadTask.dependsOn(tasks.remapJar.get())
        }
    })
    options(closureOf<Options> {
        javaVersionAutoDetect = false
        detectNewerJava = false
        javaIntegration = false
        forgeGradleIntegration = false
    })
}

modrinth {
    token.set(props.getProperty("modrinth"))
    projectId.set("w1QfAiDE")
    versionNumber.set(modVersion)
    versionType.set(type)
    uploadFile.set(tasks.remapJar as Any?)
    gameVersions.addAll(
        "1.16",
        "1.16.1",
        "1.16.2",
        "1.16.3",
        "1.16.4",
        "1.16.5",
        "1.17",
        "1.17.1",
        "1.18",
        "1.18.1",
        "1.18.2",
        "1.19",
        "1.19.1",
        "1.19.2",
    )
    changelog.set(file("changelog.md").readText())
    loaders.addAll("fabric", "quilt")
    syncBodyFrom.set(file("README.md").readText())
    dependencies {
        required.project("fabric-api")
    }
}

tasks {
    val javaVersion = JavaVersion.VERSION_1_8
    processResources {
        filesMatching("fabric.mod.json") { expand("version" to modVersion) }
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(8)
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
            // forces to not use kotlin sdk, so the kotlin language mod isn't needed
            freeCompilerArgs = freeCompilerArgs + "-Xno-param-assertions" + "-Xno-call-assertions"
        }
    }

    java {
        toolchain { languageVersion.set(JavaLanguageVersion.of(8)) }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    this.modrinth {
        dependsOn(modrinthSyncBody)
    }

    jar { from("LICENSE") { rename { "${it}_${base.archivesName.get()}" } } }

}

// if minecraft cant be imported try running gradlew --refresh-dependencies
