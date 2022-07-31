object Ktor {
    private const val ktorVersion = "2.0.2"
    const val core = "io.ktor:ktor-client-core:${ktorVersion}"
    const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${ktorVersion}"
    const val jsonSerializer = "io.ktor:ktor-serialization-kotlinx-json:${ktorVersion}"
    const val android = "io.ktor:ktor-client-okhttp:${ktorVersion}"
    const val ios = "io.ktor:ktor-client-darwin:${ktorVersion}"
}