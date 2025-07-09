plugins {
    id("java")
}

group = "dhbw.mos.algorithms"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jetbrains:annotations:26.0.2")
}

tasks.test {
    useJUnitPlatform()
}