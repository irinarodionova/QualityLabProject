# QualityLabProject

Проект поддерживает 78 версию Chrome. Если у вас другая версия, необходимо в папке `resources` подменить `chromedriver.exe` вашей версии, скачанный с https://chromedriver.chromium.org/

Для запуска теста нужно выполнить `mvn test`

Если Chrome запускается дольше обычного, необходимо увеличить таймаут `driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);`
