plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "dhbw-programming"
include("app")
include("logisim")
include("pollutionmap")
include("grade-manager")
include("media-library")
include("algorithms")
include("car-rental")
include("brainfuck")
