package io.minimal.example

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.PooledEngine
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.ashley.add
import ktx.ashley.entity
import ktx.ashley.with


class Main : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(FirstScreen())
        setScreen<FirstScreen>()
    }
}

class PositionC(var x: Float = 0f, var y: Float = 0f) : Component

class FirstScreen : KtxScreen {
    private val engine = PooledEngine()

    init {
        engine.add {
            entity {
                with<PositionC> { x = 2f; y = 9f }
            }
        }
    }

    override fun render(delta: Float) {
        clearScreen(red = 0.7f, green = 0.7f, blue = 0.7f)
    }
}
