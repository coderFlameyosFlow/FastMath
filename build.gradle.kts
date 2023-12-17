plugins {
    id("java")
}

group = "me.flame.math"
version = "1.0.0"
description = "A primitive implementation of fast mathematical operations including sqrt, round, fast even/odd checking, etc."

repositories {
    mavenCentral()
}

dependencies {
    // Add your dependencies here
}

tasks.test {
    useJUnitPlatform()
}