package me.kochoru.typing.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class InitialController {

    @RequestMapping(path = ["/"])
    fun top(): String {
        return "/index.html"
    }

}
