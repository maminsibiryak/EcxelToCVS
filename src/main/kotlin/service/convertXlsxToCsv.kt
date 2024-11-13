package service

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ru.tesla.api.FileNames
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.io.BufferedWriter

object FilesConverter {
    fun convertXlsxToCsv(fileNames: FileNames) {
        // Открываем XLSX файл
        val xlsxFile = FileInputStream(File(fileNames.xlsxFilePath))
        val workbook = XSSFWorkbook(xlsxFile)
        val sheet = workbook.getSheetAt(0) // Выбираем первый лист

        // Открываем CSV файл для записи
        BufferedWriter(FileWriter(fileNames.csvFilePath)).use { writer ->
            // Проходим по всем строкам и ячейкам
            for (row in sheet) {
                val csvRow = row.joinToString(",") { cell ->
                    // Получаем значение ячейки как строку
                    when (cell.cellType) {
                        org.apache.poi.ss.usermodel.CellType.STRING -> cell.stringCellValue
                        org.apache.poi.ss.usermodel.CellType.NUMERIC -> cell.numericCellValue.toString()
                        org.apache.poi.ss.usermodel.CellType.BOOLEAN -> cell.booleanCellValue.toString()
                        else -> ""
                    }
                }
                writer.write(csvRow)
                writer.newLine() // Переход на новую строку
            }
        }

        // Закрываем XLSX файл и освобождаем ресурсы
        workbook.close()
        xlsxFile.close()
    }
}