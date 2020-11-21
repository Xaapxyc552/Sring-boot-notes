<#import "macros/notesMacroses.ftlh" as notesMacro>
<#import "macros/pagesCommonThings.ftlh" as common>


<@common.headBodymacro "Главная страница" >
    <@common.linkToMainPage/>

    <@notesMacro.viewAllNotesMacro allNotes/>
</@common.headBodymacro>

