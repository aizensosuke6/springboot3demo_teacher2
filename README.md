2024/12/17 新增
ChiikawaGame
新增:
1.pom.xml新增OAuth2登入必備套件
2.新增SecurityConfig，用於處理OAuth2登入。
3.新增Google OAuth2 登入方式，登入後包成session，共用AJAX登入處理session的控制器。
4.application.properties 新增 Google OAuth2 必備指令(測試用帳號直接傳到GitHub沒差)
5.Login.html新增 使用Google登入 的按鈕
6.刪除memberCenter的CSRF防護(之後視情況加上)
7.無
已知BUG:
1.目前關閉CSRF防護中，之後視情況是否開啟。

已解決BUG:
1.無
