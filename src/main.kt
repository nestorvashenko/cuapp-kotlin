package com.coldos.template

/**
 * Приложение ColdOS на Kotlin.
 *
 * Поддерживается подмножество Kotlin: fun, val/var, строковые шаблоны,
 * mapOf, if/else и вызовы глобальных функций ColdOS.
 */

fun user_run_application__APP_ID__() {
    val id_app = "__APP_ID__"
    val height = "600"
    val width = "800"
    val actiontextname = "__DISPLAY_NAME__"
    val classdock = "user"
    val tooltip_app = "__DISPLAY_NAME__"
    val icon_app = "/coldos/osdata/Applications/User/$id_app/$ui_themeicons.png"
    val addappindock = true

    // Приложение уже запущено — просто поднимаем окно
    if (document.getElementById(id_app) != null) {
        Window_focus(id_app)
        return
    }

    val config = mapOf(
        "enabled" to true,
        "resizeWidth" to true,
        "maximizable" to true,
        "minWidth" to 400,
        "maxWidth" to 1000,
        "resizeHeight" to true,
        "minHeight" to 300,
        "maxHeight" to 800,
        "icon" to icon_app,
        "tooltip" to tooltip_app,
        "actiontext" to actiontextname
    )

    val htmlcode = """
        <div class="titledrag" style="height: 60px; width: calc(100% - 130px); position: absolute; user-select: none; z-index: 200;" ondblclick="Window_maximize('${id_app}')" onmousedown="move.window_systemos_api('.window', '${id_app}')"></div>
        <div id="titlebar" style="display: flex; gap: 10px; margin-top: 17px; margin-left: 17px;">
          <div class="text_ui" style="font-size: 20px; font-family: CG-Bold;">__DISPLAY_NAME__</div>
          <div style="position: absolute; right: 21px; top: 21px;">
            <button class="minimize" tip="Свернуть" onclick="Window_minimize('${id_app}'); clicksound()"></button>
            <button class="maximize" tip="Развернуть" onclick="Window_maximize('${id_app}'); clicksound()"></button>
            <button class="close" tip="Закрыть" onclick="Window_kill('${id_app}',true,true); clicksound()"></button>
          </div>
        </div>
        <div id="allcontent" class="allcontent">
          <h3>Привет из __DISPLAY_NAME__ на Kotlin!</h3>
          <p>Собрано с {{COMPILER_VER}}</p>
        </div>
    """

    val jswin = "console.log('Приложение $actiontextname загружено');"

    Window_add(htmlcode, id_app, height, width, true, config, addappindock, classdock, jswin)
}