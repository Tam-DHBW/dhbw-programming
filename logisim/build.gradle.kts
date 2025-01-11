plugins {
    id("application")
}

group = "dhbw.tam.logisim"
version = "1.0"

repositories {
    mavenCentral()
}

application {
    mainClass = "dhbw.tam.logisim.Main"
}

tasks.withType<JavaExec>() {
    standardInput = System.`in`
}