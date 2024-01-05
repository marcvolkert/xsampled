plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.xsampled"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // https://mvnrepository.com/artifact/org.apache.ws.xmlschema/xmlschema-core
    implementation("org.apache.ws.xmlschema:xmlschema-core:2.3.1")
    // https://mvnrepository.com/artifact/org.apache.ws.xmlschema/xmlschema
    implementation("org.apache.ws.xmlschema:xmlschema:2.3.1")
    // https://mvnrepository.com/artifact/net.jqwik/jqwik
    testImplementation("net.jqwik:jqwik:1.8.2")
    // https://mvnrepository.com/artifact/org.jetbrains/annotations
    compileOnly("org.jetbrains:annotations:24.1.0")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.14.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}