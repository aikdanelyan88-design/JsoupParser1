package org.example.JsoupParser

import org.jsoup.Jsoup

fun main() {
    val url = "https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/"

    try {
        val document = Jsoup.connect(url)
            .userAgent("Mozilla/5.0")
            .get()

        val quoteElements = document.select("div.Citation__Content")

        if (quoteElements.isEmpty()) {
            println("Цитаты не найдены. Возможно, структура страницы изменилась.")
        } else {
            println("Цитаты из книги «Автостопом по галактике»:\n")
            quoteElements.forEachIndexed { index, element ->
                val quote = element.text()
                println("${index + 1}. $quote\n")
            }
        }
    } catch (e: Exception) {
        println("Ошибка при получении или обработке данных: ${e.message}")
    }
}
