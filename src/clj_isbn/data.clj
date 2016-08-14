(ns clj-isbn.data)

(def data
{"978-99973" {"name" "Mongolia", "ranges" [["0" "3"] ["40" "79"] ["800" "999"]]}, "978-9981" {"name" "Morocco", "ranges" [["00" "09"] ["100" "159"] ["1600" "1999"] ["20" "79"] ["800" "949"] ["9500" "9999"]]}, "978-9929" {"name" "Guatemala", "ranges" [["0" "3"] ["40" "54"] ["550" "799"] ["8000" "9999"]]}, "978-9958" {"name" "Bosnia and Herzegovina", "ranges" [["00" "01"] ["020" "029"] ["0300" "0399"] ["040" "089"] ["0900" "0999"] ["10" "18"] ["1900" "1999"] ["20" "49"] ["500" "899"] ["9000" "9999"]]}, "978-613" {"name" "Mauritius", "ranges" [["0" "9"]]}, "978-955" {"name" "Sri Lanka", "ranges" [["0000" "1999"] ["20" "38"] ["3900" "4099"] ["41000" "43999"] ["44000" "44999"] ["4500" "4999"] ["50000" "54999"] ["550" "749"] ["7500" "7999"] ["8000" "9499"] ["95000" "99999"]]}, "978-99942" {"name" "Sudan", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-99906" {"name" "Kuwait", "ranges" [["0" "2"] ["30" "59"] ["600" "699"] ["70" "89"] ["90" "94"] ["950" "999"]]}, "978-9974" {"name" "Uruguay", "ranges" [["0" "2"] ["30" "54"] ["550" "749"] ["7500" "9099"] ["91" "94"] ["95" "99"]]}, "978-982" {"name" "South Pacific", "ranges" [["00" "09"] ["100" "699"] ["70" "89"] ["9000" "9799"] ["98000" "99999"]]}, "978-9927" {"name" "Qatar", "ranges" [["00" "09"] ["100" "399"] ["4000" "4999"]]}, "978-9948" {"name" "United Arab Emirates", "ranges" [["00" "39"] ["400" "849"] ["8500" "9999"]]}, "978-93" {"name" "India", "ranges" [["00" "09"] ["100" "499"] ["5000" "7999"] ["80000" "94999"] ["950000" "999999"]]}, "978-612" {"name" "Peru", "ranges" [["00" "29"] ["300" "399"] ["4000" "4499"] ["45000" "49999"] ["50" "99"]]}, "978-969" {"name" "Pakistan", "ranges" [["0" "1"] ["20" "22"] ["23000" "23999"] ["24" "39"] ["400" "749"] ["7500" "9999"]]}, "978-9940" {"name" "Montenegro", "ranges" [["0" "1"] ["20" "49"] ["500" "899"] ["9000" "9999"]]}, "978-980" {"name" "Venezuela", "ranges" [["00" "19"] ["200" "599"] ["6000" "9999"]]}, "978-9928" {"name" "Albania", "ranges" [["00" "09"] ["100" "399"] ["4000" "4999"]]}, "978-978" {"name" "Nigeria", "ranges" [["000" "199"] ["2000" "2999"] ["30000" "79999"] ["8000" "8999"] ["900" "999"]]}, "978-954" {"name" "Bulgaria", "ranges" [["00" "28"] ["2900" "2999"] ["300" "799"] ["8000" "8999"] ["90000" "92999"] ["9300" "9999"]]}, "978-986" {"name" "Taiwan", "ranges" [["00" "11"] ["120" "559"] ["5600" "7999"] ["80000" "99999"]]}, "978-84" {"name" "Spain", "ranges" [["00" "13"] ["140" "149"] ["15000" "19999"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["9000" "9199"] ["920000" "923999"] ["92400" "92999"] ["930000" "949999"] ["95000" "96999"] ["9700" "9999"]]}, "978-99936" {"name" "Bhutan", "ranges" [["0" "0"] ["10" "59"] ["600" "999"]]}, "978-87" {"name" "Denmark", "ranges" [["00" "29"] ["400" "649"] ["7000" "7999"] ["85000" "94999"] ["970000" "999999"]]}, "978-99948" {"name" "Eritrea", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-92" {"name" "International NGO Publishers and EU Organizations", "ranges" [["0" "5"] ["60" "79"] ["800" "899"] ["9000" "9499"] ["95000" "98999"] ["990000" "999999"]]}, "978-601" {"name" "Kazakhstan", "ranges" [["00" "19"] ["200" "699"] ["7000" "7999"] ["80000" "84999"] ["85" "99"]]}, "978-99915" {"name" "Maldives", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-9937" {"name" "Nepal", "ranges" [["0" "2"] ["30" "49"] ["500" "799"] ["8000" "9999"]]}, "978-975" {"name" "Turkey", "ranges" [["00000" "01999"] ["02" "24"] ["250" "599"] ["6000" "9199"] ["92000" "98999"] ["990" "999"]]}, "978-99947" {"name" "Tajikistan", "ranges" [["0" "2"] ["30" "69"] ["700" "999"]]}, "978-9935" {"name" "Iceland", "ranges" [["0" "0"] ["10" "39"] ["400" "899"] ["9000" "9999"]]}, "978-85" {"name" "Brazil", "ranges" [["00" "19"] ["200" "549"] ["5500" "5999"] ["60000" "69999"] ["7000" "8499"] ["85000" "89999"] ["900000" "924999"] ["92500" "94499"] ["9450" "9599"] ["96" "97"] ["98000" "99999"]]}, "978-9963" {"name" "Cyprus", "ranges" [["0" "1"] ["2000" "2499"] ["250" "279"] ["2800" "2999"] ["30" "54"] ["550" "734"] ["7350" "7499"] ["7500" "9999"]]}, "978-9952" {"name" "Azerbaijan", "ranges" [["0" "1"] ["20" "39"] ["400" "799"] ["8000" "9999"]]}, "978-977" {"name" "Egypt", "ranges" [["00" "19"] ["200" "499"] ["5000" "6999"] ["700" "849"] ["85000" "89999"] ["90" "99"]]}, "978-9938" {"name" "Tunisia", "ranges" [["00" "79"] ["800" "949"] ["9500" "9999"]]}, "978-958" {"name" "Colombia", "ranges" [["00" "56"] ["57000" "59999"] ["600" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-80" {"name" "former Czechoslovakia", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["900000" "999999"]]}, "978-99902" {"name" "Reserved Agency", "ranges" []}, "978-99961" {"name" "El Salvador", "ranges" [["0" "3"] ["40" "89"] ["900" "999"]]}, "978-99972" {"name" "Faroe Islands", "ranges" [["0" "4"] ["50" "89"] ["900" "999"]]}, "978-962" {"name" "Hong Kong, China", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "86999"] ["8700" "8999"] ["900" "999"]]}, "978-99959" {"name" "Luxembourg", "ranges" [["0" "2"] ["30" "59"] ["600" "999"]]}, "978-99960" {"name" "Malawi", "ranges" [["0" "0"] ["10" "94"] ["950" "999"]]}, "978-99922" {"name" "Guatemala", "ranges" [["0" "3"] ["40" "69"] ["700" "999"]]}, "978-82" {"name" "Norway", "ranges" [["00" "19"] ["200" "689"] ["690000" "699999"] ["7000" "8999"] ["90000" "98999"] ["990000" "999999"]]}, "978-99955" {"name" "Srpska, Republic of", "ranges" [["0" "1"] ["20" "59"] ["600" "799"] ["80" "99"]]}, "978-600" {"name" "Iran", "ranges" [["00" "09"] ["100" "499"] ["5000" "8999"] ["90000" "99999"]]}, "978-9988" {"name" "Ghana", "ranges" [["0" "2"] ["30" "54"] ["550" "749"] ["7500" "9999"]]}, "978-987" {"name" "Argentina", "ranges" [["00" "09"] ["1000" "1999"] ["20000" "29999"] ["30" "35"] ["3600" "3999"] ["4000" "4199"] ["42" "43"] ["4400" "4499"] ["45000" "48999"] ["4900" "4999"] ["500" "899"] ["9000" "9499"] ["95000" "99999"]]}, "978-618" {"name" "Greece", "ranges" [["00" "19"] ["200" "499"] ["5000" "7999"] ["80000" "99999"]]}, "978-99966" {"name" "Kuwait", "ranges" [["0" "2"] ["30" "69"] ["700" "799"] ["80" "94"]]}, "978-603" {"name" "Saudi Arabia", "ranges" [["00" "04"] ["05" "49"] ["500" "799"] ["8000" "8999"] ["90000" "99999"]]}, "978-9950" {"name" "Palestine", "ranges" [["00" "29"] ["300" "849"] ["8500" "9999"]]}, "978-9976" {"name" "Tanzania", "ranges" [["0" "5"] ["60" "89"] ["900" "989"] ["9900" "9999"]]}, "978-91" {"name" "Sweden", "ranges" [["0" "1"] ["20" "49"] ["500" "649"] ["7000" "7999"] ["85000" "94999"] ["970000" "999999"]]}, "978-99920" {"name" "Andorra", "ranges" [["0" "4"] ["50" "89"] ["900" "999"]]}, "978-9964" {"name" "Ghana", "ranges" [["0" "6"] ["70" "94"] ["950" "999"]]}, "978-960" {"name" "Greece", "ranges" [["00" "19"] ["200" "659"] ["6600" "6899"] ["690" "699"] ["7000" "8499"] ["85000" "92999"] ["93" "93"] ["9400" "9799"] ["98000" "99999"]]}, "978-99918" {"name" "Faroe Islands", "ranges" [["0" "3"] ["40" "79"] ["800" "999"]]}, "978-94" {"name" "Netherlands", "ranges" [["000" "599"] ["6000" "8999"] ["90000" "99999"]]}, "978-99957" {"name" "Malta", "ranges" [["0" "1"] ["20" "79"] ["800" "999"]]}, "978-617" {"name" "Ukraine", "ranges" [["00" "49"] ["500" "699"] ["7000" "8999"] ["90000" "99999"]]}, "978-973" {"name" "Romania", "ranges" [["0" "0"] ["100" "169"] ["1700" "1999"] ["20" "54"] ["550" "759"] ["7600" "8499"] ["85000" "88999"] ["8900" "9499"] ["95000" "99999"]]}, "978-99937" {"name" "Macau", "ranges" [["0" "1"] ["20" "59"] ["600" "999"]]}, "978-99913" {"name" "Andorra", "ranges" [["0" "2"] ["30" "35"] ["600" "604"]]}, "978-99917" {"name" "Brunei Darussalam", "ranges" [["0" "2"] ["30" "89"] ["900" "999"]]}, "978-99946" {"name" "Nepal", "ranges" [["0" "2"] ["30" "59"] ["600" "999"]]}, "978-99938" {"name" "Srpska, Republic of", "ranges" [["0" "1"] ["20" "59"] ["600" "899"] ["90" "99"]]}, "978-99949" {"name" "Mauritius", "ranges" [["0" "1"] ["20" "89"] ["900" "999"]]}, "979-12" {"name" "Italy", "ranges" [["200" "200"]]}, "978-99975" {"name" "Tajikistan", "ranges" [["0" "3"] ["40" "79"] ["800" "999"]]}, "978-99911" {"name" "Lesotho", "ranges" [["00" "59"] ["600" "999"]]}, "978-1" {"name" "English language", "ranges" [["00" "09"] ["100" "399"] ["4000" "5499"] ["55000" "86979"] ["869800" "998999"] ["9990000" "9999999"]]}, "978-956" {"name" "Chile", "ranges" [["00" "19"] ["200" "699"] ["7000" "9999"]]}, "978-9949" {"name" "Estonia", "ranges" [["0" "0"] ["10" "39"] ["400" "749"] ["75" "89"] ["9000" "9999"]]}, "978-99950" {"name" "Cambodia", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-9989" {"name" "Macedonia", "ranges" [["0" "0"] ["100" "199"] ["2000" "2999"] ["30" "59"] ["600" "949"] ["9500" "9999"]]}, "978-99908" {"name" "Malawi", "ranges" [["0" "0"] ["10" "89"] ["900" "999"]]}, "978-602" {"name" "Indonesia", "ranges" [["00" "07"] ["0800" "0899"] ["0900" "1099"] ["1100" "1199"] ["1200" "1399"] ["14000" "14999"] ["1500" "1699"] ["17000" "17999"] ["18000" "18999"] ["19000" "19999"] ["200" "619"] ["6200" "6749"] ["6750" "6999"] ["70000" "74999"] ["7500" "7999"] ["8000" "9499"] ["95000" "99999"]]}, "978-99974" {"name" "Bolivia", "ranges" [["40" "79"] ["800" "999"]]}, "978-99977" {"name" "Rwanda", "ranges" [["0" "1"] ["40" "69"] ["700" "799"]]}, "978-99923" {"name" "El Salvador", "ranges" [["0" "1"] ["20" "79"] ["800" "999"]]}, "978-99931" {"name" "Seychelles", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-99940" {"name" "Georgia", "ranges" [["0" "0"] ["10" "69"] ["700" "999"]]}, "978-99912" {"name" "Botswana", "ranges" [["0" "3"] ["400" "599"] ["60" "89"] ["900" "999"]]}, "978-99929" {"name" "Mongolia", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-99909" {"name" "Malta", "ranges" [["0" "3"] ["40" "94"] ["950" "999"]]}, "978-9957" {"name" "Jordan", "ranges" [["00" "39"] ["400" "649"] ["65" "69"] ["70" "84"] ["8500" "8799"] ["88" "99"]]}, "978-9983" {"name" "Gambia", "ranges" [["80" "94"] ["950" "989"] ["9900" "9999"]]}, "978-9961" {"name" "Algeria", "ranges" [["0" "2"] ["30" "69"] ["700" "949"] ["9500" "9999"]]}, "978-9953" {"name" "Lebanon", "ranges" [["0" "0"] ["10" "39"] ["400" "599"] ["60" "89"] ["9000" "9999"]]}, "978-99921" {"name" "Qatar", "ranges" [["0" "1"] ["20" "69"] ["700" "799"] ["8" "8"] ["90" "99"]]}, "978-607" {"name" "Mexico", "ranges" [["00" "39"] ["400" "749"] ["7500" "9499"] ["95000" "99999"]]}, "978-957" {"name" "Taiwan", "ranges" [["00" "02"] ["0300" "0499"] ["05" "19"] ["2000" "2099"] ["21" "27"] ["28000" "30999"] ["31" "43"] ["440" "819"] ["8200" "9699"] ["97000" "99999"]]}, "978-99943" {"name" "Albania", "ranges" [["0" "2"] ["30" "59"] ["600" "999"]]}, "978-9972" {"name" "Peru", "ranges" [["00" "09"] ["1" "1"] ["200" "249"] ["2500" "2999"] ["30" "59"] ["600" "899"] ["9000" "9999"]]}, "978-0" {"name" "English language", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["900000" "949999"] ["9500000" "9999999"]]}, "978-9975" {"name" "Moldova", "ranges" [["0" "0"] ["100" "299"] ["3000" "3999"] ["4000" "4499"] ["45" "89"] ["900" "949"] ["9500" "9999"]]}, "978-972" {"name" "Portugal", "ranges" [["0" "1"] ["20" "54"] ["550" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-616" {"name" "Thailand", "ranges" [["00" "19"] ["200" "699"] ["7000" "8999"] ["90000" "99999"]]}, "978-976" {"name" "Caribbean Community", "ranges" [["0" "3"] ["40" "59"] ["600" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-99954" {"name" "Bolivia", "ranges" [["0" "2"] ["30" "69"] ["700" "879"] ["88" "99"]]}, "978-9985" {"name" "Estonia", "ranges" [["0" "4"] ["50" "79"] ["800" "899"] ["9000" "9999"]]}, "978-606" {"name" "Romania", "ranges" [["0" "0"] ["10" "49"] ["500" "799"] ["8000" "9099"] ["910" "919"] ["92000" "97499"] ["975" "999"]]}, "978-9924" {"name" "Cambodia", "ranges" [["30" "39"] ["500" "649"] ["9000" "9999"]]}, "978-9925" {"name" "Cyprus", "ranges" [["0" "2"] ["30" "54"] ["550" "734"] ["7350" "9999"]]}, "978-608" {"name" "Macedonia", "ranges" [["0" "0"] ["10" "19"] ["200" "449"] ["4500" "6499"] ["65000" "69999"] ["7" "9"]]}, "978-981" {"name" "Singapore", "ranges" [["00" "16"] ["17000" "19999"] ["200" "299"] ["3000" "3099"] ["310" "399"] ["4000" "9999"]]}, "978-9955" {"name" "Lithuania", "ranges" [["00" "39"] ["400" "929"] ["9300" "9999"]]}, "978-964" {"name" "Iran", "ranges" [["00" "14"] ["150" "249"] ["2500" "2999"] ["300" "549"] ["5500" "8999"] ["90000" "96999"] ["970" "989"] ["9900" "9999"]]}, "978-9956" {"name" "Cameroon", "ranges" [["0" "0"] ["10" "39"] ["400" "899"] ["9000" "9999"]]}, "978-9959" {"name" "Libya", "ranges" [["0" "1"] ["20" "79"] ["800" "949"] ["9500" "9699"] ["970" "979"] ["98" "99"]]}, "978-99927" {"name" "Albania", "ranges" [["0" "2"] ["30" "59"] ["600" "999"]]}, "978-99924" {"name" "Nicaragua", "ranges" [["0" "1"] ["20" "79"] ["800" "999"]]}, "978-989" {"name" "Portugal", "ranges" [["0" "1"] ["20" "54"] ["550" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-99941" {"name" "Armenia", "ranges" [["0" "2"] ["30" "79"] ["800" "999"]]}, "978-99951" {"name" "Reserved Agency", "ranges" []}, "978-99952" {"name" "Mali", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-9951" {"name" "Kosova", "ranges" [["00" "39"] ["400" "849"] ["8500" "9999"]]}, "978-99916" {"name" "Namibia", "ranges" [["0" "2"] ["30" "69"] ["700" "999"]]}, "978-88" {"name" "Italy", "ranges" [["00" "19"] ["200" "599"] ["6000" "8499"] ["85000" "89999"] ["900000" "909999"] ["910" "929"] ["9300" "9399"] ["940000" "949999"] ["95000" "99999"]]}, "978-9954" {"name" "Morocco", "ranges" [["0" "1"] ["20" "39"] ["400" "799"] ["8000" "9999"]]}, "978-99904" {"name" "Curaçao", "ranges" [["0" "5"] ["60" "89"] ["900" "999"]]}, "978-9987" {"name" "Tanzania", "ranges" [["00" "39"] ["400" "879"] ["8800" "9999"]]}, "978-99962" {"name" "Mongolia", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-963" {"name" "Hungary", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["9000" "9999"]]}, "979-11" {"name" "Korea, Republic", "ranges" [["00" "24"] ["250" "549"] ["5500" "8499"] ["85000" "94999"] ["950000" "999999"]]}, "978-615" {"name" "Hungary", "ranges" [["00" "09"] ["100" "499"] ["5000" "7999"] ["80000" "89999"]]}, "978-9973" {"name" "Tunisia", "ranges" [["00" "05"] ["060" "089"] ["0900" "0999"] ["10" "69"] ["700" "969"] ["9700" "9999"]]}, "978-9979" {"name" "Iceland", "ranges" [["0" "4"] ["50" "64"] ["650" "659"] ["66" "75"] ["760" "899"] ["9000" "9999"]]}, "978-99945" {"name" "Namibia", "ranges" [["0" "5"] ["60" "89"] ["900" "999"]]}, "978-974" {"name" "Thailand", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["90000" "94999"] ["9500" "9999"]]}, "978-99905" {"name" "Bolivia", "ranges" [["0" "3"] ["40" "79"] ["800" "999"]]}, "978-99971" {"name" "Myanmar", "ranges" [["0" "5"] ["60" "84"] ["850" "999"]]}, "978-99926" {"name" "Honduras", "ranges" [["0" "0"] ["10" "59"] ["600" "869"] ["87" "89"] ["90" "99"]]}, "978-953" {"name" "Croatia", "ranges" [["0" "0"] ["10" "14"] ["150" "509"] ["51" "54"] ["55000" "59999"] ["6000" "9499"] ["95000" "99999"]]}, "978-3" {"name" "German language", "ranges" [["00" "02"] ["030" "033"] ["0340" "0369"] ["03700" "03999"] ["04" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["900000" "949999"] ["9500000" "9539999"] ["95400" "96999"] ["9700000" "9899999"] ["99000" "99499"] ["99500" "99999"]]}, "978-9966" {"name" "Kenya", "ranges" [["000" "149"] ["1500" "1999"] ["20" "69"] ["7000" "7499"] ["750" "959"] ["9600" "9999"]]}, "978-9946" {"name" "Korea, P.D.R.", "ranges" [["0" "1"] ["20" "39"] ["400" "899"] ["9000" "9999"]]}, "978-99956" {"name" "Albania", "ranges" [["00" "59"] ["600" "859"] ["86" "99"]]}, "978-89" {"name" "Korea, Republic", "ranges" [["00" "24"] ["250" "549"] ["5500" "8499"] ["85000" "94999"] ["950000" "969999"] ["97000" "98999"] ["990" "999"]]}, "978-619" {"name" "Bulgaria", "ranges" [["00" "14"] ["150" "699"] ["7000" "8999"] ["90000" "99999"]]}, "978-9926" {"name" "Bosnia and Herzegovina", "ranges" [["0" "1"] ["20" "39"] ["400" "799"] ["8000" "9999"]]}, "978-983" {"name" "Malaysia", "ranges" [["00" "01"] ["020" "199"] ["2000" "3999"] ["40000" "44999"] ["45" "49"] ["50" "79"] ["800" "899"] ["9000" "9899"] ["99000" "99999"]]}, "978-966" {"name" "Ukraine", "ranges" [["00" "12"] ["130" "139"] ["14" "14"] ["1500" "1699"] ["170" "199"] ["2000" "2789"] ["279" "289"] ["2900" "2999"] ["300" "699"] ["7000" "8999"] ["90000" "90999"] ["910" "949"] ["95000" "97999"] ["980" "999"]]}, "978-99969" {"name" "Oman", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-9942" {"name" "Ecuador", "ranges" [["00" "84"] ["8500" "8999"] ["900" "984"] ["9850" "9999"]]}, "978-9977" {"name" "Costa Rica", "ranges" [["00" "89"] ["900" "989"] ["9900" "9999"]]}, "978-99944" {"name" "Ethiopia", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-99934" {"name" "Dominican Republic", "ranges" [["0" "1"] ["20" "79"] ["800" "999"]]}, "978-99963" {"name" "Cambodia", "ranges" [["00" "49"] ["500" "919"] ["92" "99"]]}, "978-9947" {"name" "Algeria", "ranges" [["0" "1"] ["20" "79"] ["800" "999"]]}, "978-86" {"name" "former Yugoslavia", "ranges" [["00" "29"] ["300" "599"] ["6000" "7999"] ["80000" "89999"] ["900000" "999999"]]}, "978-99933" {"name" "Nepal", "ranges" [["0" "2"] ["30" "59"] ["600" "999"]]}, "978-9965" {"name" "Kazakhstan", "ranges" [["00" "39"] ["400" "899"] ["9000" "9999"]]}, "978-99903" {"name" "Mauritius", "ranges" [["0" "1"] ["20" "89"] ["900" "999"]]}, "978-9931" {"name" "Algeria", "ranges" [["00" "29"] ["300" "899"] ["9000" "9999"]]}, "978-99976" {"name" "Srpska, Republic of", "ranges" [["0" "1"] ["20" "59"] ["600" "799"]]}, "978-959" {"name" "Cuba", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "99999"]]}, "978-9930" {"name" "Costa Rica", "ranges" [["00" "49"] ["500" "939"] ["9400" "9999"]]}, "978-9982" {"name" "Zambia", "ranges" [["00" "79"] ["800" "989"] ["9900" "9999"]]}, "978-984" {"name" "Bangladesh", "ranges" [["00" "39"] ["400" "799"] ["8000" "8999"] ["90000" "99999"]]}, "978-99930" {"name" "Armenia", "ranges" [["0" "4"] ["50" "79"] ["800" "999"]]}, "978-99901" {"name" "Bahrain", "ranges" [["00" "49"] ["500" "799"] ["80" "99"]]}, "978-9968" {"name" "Costa Rica", "ranges" [["00" "49"] ["500" "939"] ["9400" "9999"]]}, "978-609" {"name" "Lithuania", "ranges" [["00" "39"] ["400" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-99925" {"name" "Paraguay", "ranges" [["0" "3"] ["40" "79"] ["800" "999"]]}, "978-9941" {"name" "Georgia", "ranges" [["0" "0"] ["10" "39"] ["400" "899"] ["9000" "9999"]]}, "978-9986" {"name" "Lithuania", "ranges" [["00" "39"] ["400" "899"] ["9000" "9399"] ["940" "969"] ["97" "99"]]}, "978-9960" {"name" "Saudi Arabia", "ranges" [["00" "59"] ["600" "899"] ["9000" "9999"]]}, "978-81" {"name" "India", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["900000" "999999"]]}, "978-99970" {"name" "Haiti", "ranges" [["0" "4"] ["50" "89"] ["900" "999"]]}, "978-7" {"name" "China, People's Republic", "ranges" [["00" "09"] ["100" "499"] ["5000" "7999"] ["80000" "89999"] ["900000" "999999"]]}, "978-967" {"name" "Malaysia", "ranges" [["00" "00"] ["0100" "0999"] ["10000" "19999"] ["2000" "2499"] ["300" "499"] ["5000" "5999"] ["60" "89"] ["900" "989"] ["9900" "9989"] ["99900" "99999"]]}, "978-99910" {"name" "Sierra Leone", "ranges" [["0" "2"] ["30" "89"] ["900" "999"]]}, "978-9945" {"name" "Dominican Republic", "ranges" [["00" "00"] ["010" "079"] ["08" "39"] ["400" "569"] ["57" "57"] ["580" "849"] ["8500" "9999"]]}, "978-979" {"name" "Indonesia", "ranges" [["000" "099"] ["1000" "1499"] ["15000" "19999"] ["20" "29"] ["3000" "3999"] ["400" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-99965" {"name" "Macau", "ranges" [["0" "3"] ["40" "62"] ["630" "999"]]}, "978-99914" {"name" "Suriname", "ranges" [["0" "4"] ["50" "89"] ["900" "999"]]}, "978-9980" {"name" "Papua New Guinea", "ranges" [["0" "3"] ["40" "89"] ["900" "989"] ["9900" "9999"]]}, "978-99919" {"name" "Benin", "ranges" [["0" "2"] ["300" "399"] ["40" "69"] ["70" "79"] ["800" "849"] ["850" "899"] ["900" "999"]]}, "978-9962" {"name" "Panama", "ranges" [["00" "54"] ["5500" "5599"] ["56" "59"] ["600" "849"] ["8500" "9999"]]}, "978-968" {"name" "Mexico", "ranges" [["01" "39"] ["400" "499"] ["5000" "7999"] ["800" "899"] ["9000" "9999"]]}, "978-9984" {"name" "Latvia", "ranges" [["00" "49"] ["500" "899"] ["9000" "9999"]]}, "978-99964" {"name" "Nicaragua", "ranges" [["0" "1"] ["20" "79"] ["800" "999"]]}, "978-621" {"name" "Philippines", "ranges" [["00" "29"] ["400" "599"] ["8000" "8999"] ["95000" "99999"]]}, "978-9932" {"name" "Lao People's Democratic Republic", "ranges" [["00" "39"] ["400" "849"] ["8500" "9999"]]}, "978-9939" {"name" "Armenia", "ranges" [["0" "4"] ["50" "79"] ["800" "899"] ["9000" "9999"]]}, "978-99968" {"name" "Botswana", "ranges" [["0" "3"] ["400" "599"] ["60" "89"] ["900" "999"]]}, "978-90" {"name" "Netherlands", "ranges" [["00" "19"] ["200" "499"] ["5000" "6999"] ["70000" "79999"] ["800000" "849999"] ["8500" "8999"] ["90" "90"] ["94" "94"]]}, "978-620" {"name" "Mauritius", "ranges" [["0" "9"]]}, "978-9971" {"name" "Singapore", "ranges" [["0" "5"] ["60" "89"] ["900" "989"] ["9900" "9999"]]}, "978-99932" {"name" "Malta", "ranges" [["0" "0"] ["10" "59"] ["600" "699"] ["7" "7"] ["80" "99"]]}, "978-9967" {"name" "Kyrgyz Republic", "ranges" [["00" "39"] ["400" "899"] ["9000" "9999"]]}, "978-985" {"name" "Belarus", "ranges" [["00" "39"] ["400" "599"] ["6000" "8999"] ["90000" "99999"]]}, "979-10" {"name" "France", "ranges" [["00" "19"] ["200" "699"] ["7000" "8999"] ["90000" "97599"] ["976000" "999999"]]}, "978-99958" {"name" "Bahrain", "ranges" [["0" "4"] ["50" "93"] ["940" "949"] ["950" "999"]]}, "978-9934" {"name" "Latvia", "ranges" [["0" "0"] ["10" "49"] ["500" "799"] ["8000" "9999"]]}, "978-4" {"name" "Japan", "ranges" [["00" "19"] ["200" "699"] ["7000" "8499"] ["85000" "89999"] ["900000" "949999"] ["9500000" "9999999"]]}, "978-9943" {"name" "Uzbekistan", "ranges" [["00" "29"] ["300" "399"] ["4000" "9749"] ["975" "999"]]}, "978-950" {"name" "Argentina", "ranges" [["00" "49"] ["500" "899"] ["9000" "9899"] ["99000" "99999"]]}, "978-611" {"name" "Thailand", "ranges" []}, "978-961" {"name" "Slovenia", "ranges" [["00" "19"] ["200" "599"] ["6000" "8999"] ["90000" "94999"]]}, "978-9933" {"name" "Syria", "ranges" [["0" "0"] ["10" "39"] ["400" "899"] ["9000" "9999"]]}, "978-605" {"name" "Turkey", "ranges" [["01" "02"] ["030" "039"] ["04" "09"] ["100" "399"] ["4000" "5999"] ["60000" "89999"] ["9000" "9999"]]}, "978-988" {"name" "Hong Kong, China", "ranges" [["00" "11"] ["12000" "14999"] ["15000" "16999"] ["17000" "19999"] ["200" "769"] ["77000" "79999"] ["8000" "9699"] ["97000" "99999"]]}, "978-614" {"name" "Lebanon", "ranges" [["00" "39"] ["400" "799"] ["8000" "9499"] ["95000" "99999"]]}, "978-9970" {"name" "Uganda", "ranges" [["00" "39"] ["400" "899"] ["9000" "9999"]]}, "978-99928" {"name" "Georgia", "ranges" [["0" "0"] ["10" "79"] ["800" "999"]]}, "978-9936" {"name" "Afghanistan", "ranges" [["0" "1"] ["20" "39"] ["400" "799"] ["8000" "9999"]]}, "978-604" {"name" "Vietnam", "ranges" [["0" "4"] ["50" "89"] ["900" "979"] ["9800" "9999"]]}, "978-2" {"name" "French language", "ranges" [["00" "19"] ["200" "349"] ["35000" "39999"] ["400" "699"] ["7000" "8399"] ["84000" "89999"] ["900000" "949999"] ["9500000" "9999999"]]}, "978-9944" {"name" "Turkey", "ranges" [["0000" "0999"] ["100" "499"] ["5000" "5999"] ["60" "69"] ["700" "799"] ["80" "89"] ["900" "999"]]}, "978-951" {"name" "Finland", "ranges" [["0" "1"] ["20" "54"] ["550" "889"] ["8900" "9499"] ["95000" "99999"]]}, "978-952" {"name" "Finland", "ranges" [["00" "19"] ["200" "499"] ["5000" "5999"] ["60" "65"] ["6600" "6699"] ["67000" "69999"] ["7000" "7999"] ["80" "94"] ["9500" "9899"] ["99000" "99999"]]}, "978-971" {"name" "Philippines", "ranges" [["000" "015"] ["0160" "0199"] ["02" "02"] ["0300" "0599"] ["06" "49"] ["500" "849"] ["8500" "9099"] ["91000" "95999"] ["9600" "9699"] ["97" "98"] ["9900" "9999"]]}, "978-970" {"name" "Mexico", "ranges" [["01" "59"] ["600" "899"] ["9000" "9099"] ["91000" "96999"] ["9700" "9999"]]}, "978-99953" {"name" "Paraguay", "ranges" [["0" "2"] ["30" "79"] ["800" "939"] ["94" "99"]]}, "978-99935" {"name" "Haiti", "ranges" [["0" "2"] ["30" "59"] ["600" "699"] ["7" "8"] ["90" "99"]]}, "978-99967" {"name" "Paraguay", "ranges" [["0" "1"] ["20" "59"] ["600" "899"]]}, "978-83" {"name" "Poland", "ranges" [["00" "19"] ["200" "599"] ["60000" "69999"] ["7000" "8499"] ["85000" "89999"] ["900000" "999999"]]}, "978-99939" {"name" "Guatemala", "ranges" [["0" "5"] ["60" "89"] ["900" "999"]]}, "978-5" {"name" "former U.S.S.R", "ranges" [["00000" "00499"] ["0050" "0099"] ["01" "19"] ["200" "420"] ["4210" "4299"] ["430" "430"] ["4310" "4399"] ["440" "440"] ["4410" "4499"] ["450" "699"] ["7000" "8499"] ["85000" "89999"] ["900000" "909999"] ["91000" "91999"] ["9200" "9299"] ["93000" "94999"] ["9500000" "9500999"] ["9501" "9799"] ["98000" "98999"] ["9900000" "9909999"] ["9910" "9999"]]}, "978-9978" {"name" "Ecuador", "ranges" [["00" "29"] ["300" "399"] ["40" "94"] ["950" "989"] ["9900" "9999"]]}, "978-965" {"name" "Israel", "ranges" [["00" "19"] ["200" "599"] ["7000" "7999"] ["90000" "99999"]]}})