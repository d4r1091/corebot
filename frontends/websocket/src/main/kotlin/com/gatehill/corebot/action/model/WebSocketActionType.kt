package com.gatehill.corebot.action.model

/**
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
class WebSocketOperationType(name: String, description: String) : OperationType(name, description) {
    companion object {
        val SET_REAL_NAME = OperationType("SET_REAL_NAME", "set real name")
        val SET_USERNAME = OperationType("SET_USERNAME", "set username")
        val TERMINATE_SESSION = OperationType("TERMINATE_SESSION", "terminate session")
    }
}
