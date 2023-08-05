plugins {
    kotlin("jvm") version "1.9.0"
    id("fabric-loom") version "1.3-SNAPSHOT"
}

version = "1.6.0"
group = "pl.vemu"
base.archivesName = "diamold"

dependencies {
    minecraft("com.mojang:minecraft:1.19.3")
    mappings("net.fabricmc:yarn:1.19.3+build.5:v2")

    modImplementation("net.fabricmc:fabric-loader:0.14.22")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.76.1+1.19.3")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.8+kotlin.1.9.0")
}

tasks {
    val javaVersion = JavaVersion.VERSION_17
    processResources {
        filesMatching("fabric.mod.json") { expand("version" to version) }
    }

    withType<JavaCompile> {
        options.release = 17
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
        }
    }

    java {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    jar { from("LICENSE") { rename { "${it}_${base.archivesName.get()}" } } }

}
