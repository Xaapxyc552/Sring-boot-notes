<#import "macros/notesMacroses.ftlh" as notesMacro>
<#import "spring.ftl" as spring/>
<#import "macros/weather.ftlh" as weather>
<#import "macros/pagesCommonThings.ftlh" as common>
<#import "macros/newsMacroses.ftlh" as newsMacro>

<@common.headBodymacro "Все записки">
    <@common.linkToMainPage/>

    <#if noteNotFoundedId??>
        Записка с ID=${noteNotFoundedId} не найдена <br>
    <#else>
        <table>
        <tr>
        <th>
        <div class="form-style-2">
            <@notesMacro.viewAllNotesMacro allNotesMacro=allNotes/>
        </div>
        <div class="form-style-2">
        <#if noteForm??>
            <@notesMacro.noteFormMacro noteForm "${pathToSend}" "${buttonText}"/>

        </#if>
    </#if>
    </div>
    </th>
    <th align="center">
   <@weather.viewWeatherMacro/>
    </th>
    <th>
        <@newsMacro.viewAllNewsMacro listOfNews/>
    </th>
    </tr>
    </table>
</@common.headBodymacro>
