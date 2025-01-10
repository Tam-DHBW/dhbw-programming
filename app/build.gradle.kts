plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:26.0.1")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}