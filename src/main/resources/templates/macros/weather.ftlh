<#macro viewWeatherMacro>
    <div id="SinoptikInformer" style="width:265px;" class="SinoptikInformer type1c1">
        <div class="siHeader">
            <div class="siLh">
                <div class="siMh"><a onmousedown="siClickCount();" class="siLogo" href="https://sinoptik.ua/"
                                     target="_blank" rel="nofollow" title="Погода"> </a>Погода <span
                            id="siHeader"></span></div>
            </div>
        </div>
        <div class="siBody"><a onmousedown="siClickCount();" href="https://sinoptik.ua/погода-киев"
                               title="Погода в Киеве" target="_blank">
                <div class="siCity">
                    <div class="siCityName"><span>Киев</span></div>
                    <div id="siCont0" class="siBodyContent">
                        <div class="siLeft">
                            <div class="siTerm"></div>
                            <div class="siT" id="siT0"></div>
                            <div id="weatherIco0"></div>
                        </div>
                        <div class="siInf"><p>влажность: <span id="vl0"></span></p>
                            <p>давление: <span id="dav0"></span></p>
                            <p>ветер: <span id="wind0"></span></p></div>
                    </div>
                </div>
            </a><a onmousedown="siClickCount();" href="https://sinoptik.ua/погода-белая-церковь"
                   title="Погода в Белой Церкви" target="_blank">
                <div class="siCity">
                    <div class="siCityName"><span>Белая Церковь</span></div>
                    <div id="siCont1" class="siBodyContent">
                        <div class="siLeft">
                            <div class="siTerm"></div>
                            <div class="siT" id="siT1"></div>
                            <div id="weatherIco1"></div>
                        </div>
                        <div class="siInf"><p>влажность: <span id="vl1"></span></p>
                            <p>давление: <span id="dav1"></span></p>
                            <p>ветер: <span id="wind1"></span></p></div>
                    </div>
                </div>
            </a><a onmousedown="siClickCount();" href="https://sinoptik.ua/погода-звенигородка-303009051"
                   title="Погода в Звенигородке" target="_blank">
                <div class="siCity">
                    <div class="siCityName"><span>Звенигородка</span></div>
                    <div id="siCont2" class="siBodyContent">
                        <div class="siLeft">
                            <div class="siTerm"></div>
                            <div class="siT" id="siT2"></div>
                            <div id="weatherIco2"></div>
                        </div>
                        <div class="siInf"><p>влажность: <span id="vl2"></span></p>
                            <p>давление: <span id="dav2"></span></p>
                            <p>ветер: <span id="wind2"></span></p></div>
                    </div>
                </div>
            </a>
            <div class="siLinks">Погода на 10 дней от <a href="https://sinoptik.ua/10-дней" title="Погода на 10 дней"
                                                         target="_blank" onmousedown="siClickCount();"> sinoptik.ua</a>
            </div>
        </div>
        <div class="siFooter">
            <div class="siLf">
                <div class="siMf"></div>
            </div>
        </div>
    </div>
    <script type="text/javascript" charset="UTF-8"
            src="//sinoptik.ua/informers_js.php?title=4&amp;wind=3&amp;cities=303010783,303001150,303009051&amp;lang=ru"></script>
</#macro>
