plugins {
    id("java")
}

group = "ru.laba1"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir {
        dirs("libs")
    }
}


dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation(":fastcgi-lib")
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


tasks.test {
    useJUnitPlatform()
}


tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "ru.laba1.Server"
        )
    }
}

tasks.register<Jar>("deploy.sh") {
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(
            "Main-Class" to "ru.laba1.Server"
        )
    }
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

    doLast {
        val targetDir = file("helios/applab1/fcgi-bin")
        if (!targetDir.exists()) {
            targetDir.mkdirs()
        }
        val targetFile = targetDir.resolve("server.jar")
        archiveFile.get().asFile.copyTo(targetFile, overwrite = true)
    }

}
/*
tasks.check {
    dependsOn("checkstyleMain")
    dependsOn("checkstyleTest")
}*/