<#macro headBodymacro pageTitle>
    <html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>${pageTitle}</title>
        <link rel="stylesheet" href="/resources/css/styles.css">
        <style type="text/css">
            A {
                color: #000000; /* Цвет обычной ссылки */
            }

            A:visited {
                color: #000000; /* Цвет посещенной ссылки */
            }
        </style>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>

<#macro linkToMainPage>
    <table>
        <h3>
            <tr><a href="/main"> Главная страница</a>
            </tr>
            <br>
            <tr><a href="/notes"> Записки</a>
            </tr>
            <br>
            <tr><a href="/news/insertForm"> Новая новость</a>
            </tr>
            <br>
        </h3>
    </table>
</#macro>


