<#import "spring.ftl" as spring/>
<#import "macros/pagesCommonThings.ftlh" as common>

<@common.headBodymacro "Создание новой новости">
    <@common.linkToMainPage/>
    <div>

        <h3>
            <form action="/news/create">
                <table>
                    <tr>
                        <td align="center">
                            Введите заголовок для новости: <@spring.formInput "newsForm.title" "" "text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            Введите страницу для новости: <@spring.formInput "newsForm.source" "" "text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center"><input type="submit" value="Создать новость">
                        </td>
                    </tr>

                </table>
            </form>

        </h3>
    </div>
</@common.headBodymacro>
