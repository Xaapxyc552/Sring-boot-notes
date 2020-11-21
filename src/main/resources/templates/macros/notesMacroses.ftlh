<#macro viewAllNotesMacro allNotesMacro>
    <#if allNotesMacro??>
        <table border="3">
            <tr>
                <th><a href="/notes/new">Новая записка</a></th>
            </tr>
            <#list allNotesMacro as note>
                <h3>
                <tr>
                    <td>
                            <a href="/notes/${note.id}">${note.title}</a>
                            <a href="/notes/delete/${note.id}">[X]</a>

                    </td>
                </tr>
                </h3>
                <#else><h3>Записок нет</h3>
            </#list>
        </table>
    <#else> <h3>Записок нет</h3></#if>
</#macro>

<#macro noteFormMacro noteFormMacro pathToSend buttonText>
    <#if noteForm??>
        <form action=${pathToSend} method="POST" name="noteForm" id="noteForm">
            <table>
                <tr>
                    <td align="center">
                        <@spring.formTextarea "noteForm.title" 'rows="1" cols="15"'/>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <@spring.formTextarea "noteForm.body" 'rows="20" cols="50"'/>
                    </td>
                </tr>
                <tr>
                    <td align="center"><input type="submit" value="${buttonText}"></td>
                </tr>
            </table>
        </form>
    </#if>
</#macro>