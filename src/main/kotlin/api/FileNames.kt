package ru.tesla.api

/**
 * Класс для хранения пути и имен файлов:
 * @param xlsxFilePath Файл xlsx формата. Исходные данные
 * @param csvFilePath Файл csv формата. Выходные данные
 */
data class FileNames(val xlsxFilePath: String, val csvFilePath: String)
