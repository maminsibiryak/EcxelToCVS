package ru.tesla

import ru.tesla.api.FileNames
import service.FilesConverter

fun main() {
    val input = readlnOrNull()
    val xlsxFilePath = input.toString() // Путь к XLSX файлу
    val csvFilePath = "output.csv"    // Путь для сохранения CSV файла

    FilesConverter.convertXlsxToCsv(FileNames(xlsxFilePath, csvFilePath))
    println("Конвертация завершена! Файл сохранен по пути: $csvFilePath")
}