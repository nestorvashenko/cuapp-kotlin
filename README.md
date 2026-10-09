# Шаблон приложения ColdOS — Kotlin

Заготовка приложения ColdOS на Kotlin.

> ColdOS исполняет JavaScript. Kotlin-код не запускается как есть:
> `cldcli build` конвертирует поддерживаемое подмножество в JS
> (парсер `prkotlin.js`).

## Создание проекта

```bash
cldcli init myapp --lang kotlin
```

## Поддерживаемое подмножество

| Возможность | Пример |
|---|---|
| Точка входа | `fun user_run_application_<id>() { }` |
| Переменные | `val x = "строка"`, `var y = 1` |
| Строковые шаблоны | `"текст $x и ${y}"` |
| Многострочные шаблоны | `"""..."""` |
| Словари | `mapOf("k" to v)` → `{ k: v }` |
| Списки | `listOf(a, b)` → `[a, b]` |
| Логика | `if (cond) { }`, `else { }` |
| Возврат | `return`, `return value` |
| Вызовы ColdOS | `Window_add(...)`, `popup(...)` |

**Не поддерживается:** классы и data-классы, лямбды (`->`),
extension-функции, generics на уровне функции, корутины, аннотации.

## Структура

```
myapp/
├── src/
│   ├── main.kt          # код приложения
│   └── index.css        # стили
├── assets/              # иконки
├── package.json
└── README.md
```

## Сборка

```bash
cldcli build
```