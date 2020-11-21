<#macro viewAllNewsMacro allNewsMacro>
    <#if allNewsMacro??>
        <table border="3">
            <a href="/news/update-all">
                <h4>Обновить все новости</h4>
            </a>
            <#list allNewsMacro as news>
                <tr>
                    <td>
                        <font size="5">
                            <#if !news.checked >
                                <span style="color: red; ">
                                    [NEW]
                                </span>
                            <#else>
                                <a href="/news/mark-as-unread/${news.id}">
                                    <span style="color: blue; ">
                                        [MARK NEW]
                                    </span>
                                </a>
                            </#if>
                            <a href="/news/redirect-at-new/${news.id}">
                                <font size="5">
                                    ${news.title}<br>
                                </font>
                                <font size="3">
                                    ${news.text}
                                </font>
                            </a>
                        </font><br>
                    </td>
                </tr>
            </#list>
        </table>
    <#else> <h3>Список новостей пуст</h3></#if>
</#macro>