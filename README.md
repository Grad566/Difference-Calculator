# Описание проекта

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных

### Hexlet tests and linter status:
[![Actions Status](https://github.com/Grad566/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Grad566/java-project-71/actions)

[![Maintainability](https://api.codeclimate.com/v1/badges/53a9a04c250683a0ae35/maintainability)](https://codeclimate.com/github/Grad566/java-project-71/maintainability)

[![myTest](https://github.com/Grad566/java-project-71/actions/workflows/myTets.yml/badge.svg)](https://github.com/Grad566/java-project-71/actions/workflows/myTets.yml)

<a href="https://codeclimate.com/github/Grad566/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/53a9a04c250683a0ae35/test_coverage" /></a>

### Аскинема разницы
https://asciinema.org/a/W4OJSu7EHlJ6sLVWzcWrwVcUu

### Аскинема для формата yaml
https://asciinema.org/a/abmodcoA7aN048TjIAFWnsMMj

### Аскинема для формата вывода plain
https://asciinema.org/a/CaIXyCr0jxPc3GFJprYP3SxWg

### Аскинема для формата вывода json
https://asciinema.org/a/Wd1y3vQ4RmoRt0BujvBPq7r26

## Локальный запуск
Требования:
 - jdk 20
 - gradle 8.5

Использовать команду make run-dist опционально указать формат вывода через флаг -f и пути к файлам для сравнения.
```
make run-dist -f plain file1.yml file2.yml
```
Дополнительные команды:
```
// сборка приложения
make build 
```

Тесты и chekStyle через ./gradlew <команада>
