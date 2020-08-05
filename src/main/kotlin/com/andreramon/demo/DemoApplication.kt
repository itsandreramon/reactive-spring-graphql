package com.andreramon.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.tools.agent.ReactorDebugAgent

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
  ReactorDebugAgent.init()
  runApplication<DemoApplication>(*args)
}
