plugins {
    kotlin("jvm") version "1.4.10"
    id("fabric-loom") version "0.5-SNAPSHOT"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val modId = "diamold"
val modVersion = "1.0-SNAPSHOT"
val group = "pl.vemu"
val minecraftVersion = "1.16.3"
val fabricApiVersion = "0.24.1+build.412-1.16"
val kotlinVersion = "1.4.0+build.1"

base {
    archivesBaseName = "$modVersion+$minecraftVersion"
}


project.group = group
version = modVersion


repositories {
    maven(url = "https://maven.fabricmc.net/") {
        name = "Fabric"
    }
    maven(url = "https://kotlin.bintray.com/kotlinx") {
        name = "Kotlinx"
    }
    mavenLocal()
    mavenCentral()
    jcenter()
}

minecraft { }

dependencies {
    minecraft(group = "com.mojang", name = "minecraft", version = minecraftVersion)
    mappings(group = "net.fabricmc", name = "yarn", version = "$minecraftVersion+build.47", classifier = "v2")

    modImplementation(group = "net.fabricmc", name = "fabric-loader", version = "0.10.2+build.210")
    modImplementation(group = "net.fabricmc.fabric-api", name = "fabric-api", version = fabricApiVersion)

    modImplementation(group = "net.fabricmc", name = "fabric-language-kotlin", version = "1.4.0+build.1")
//    modImplementation("$group:$modId:$modVersion+local")

//    modImplementation("io.github.prospector.modmenu:ModMenu:_")
}

//val publishToMavenLocal = rootProject.tasks.getByName<Task>("publishToMavenLocal")

//val remapJar = tasks.getByName<RemapJarTask>("remapJar") {
//    (this as Task).dependsOn(publishToMavenLocal)
//}

tasks.getByName<ProcessResources>("processResources") {
    filesMatching("fabric.mod.json") {
        expand(
            mutableMapOf(
                "modid" to modId,
                "version" to modVersion,
                "kotlinVersion" to kotlinVersion,
                "fabricApiVersion" to fabricApiVersion
            )
        )
    }
}