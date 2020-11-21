<#import "macros/notesMacroses.ftlh" as notesMacro>
<#import "spring.ftl" as spring/>
<#import "macros/pagesCommonThings.ftlh" as common>;

<@common.headBodymacro "Записки" >
        <@common.linkToMainPage />
    <h1>Уверены что хотите удалить записку с ID=${noteToDeleteId}. </h1><br>
    <h1><a href="${noteToDeleteId}/sure">Да, хочу</a></h1>
</@common.headBodymacro>

