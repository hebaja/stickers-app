# Stickers App

Este aplicativo foi construído durante a imersão Java realizada pela Alura entre os dias 27 e 31 de março. O aplicativo busca diversos dados de APIs e gera imagens stilo stickers que pode ser usado em redes sociais e aplicativos de comunicação instantânea. As imagens usadas nesse projeto são: posters de filmes do imdb, fotos dos bancos de dados da Nasa, e logos de linguagens de programção. Mas com alguns ajustes,
outros tipos de imagens podem ser usadas.

Acabei optando por escrever todas as classes dentro de uma pasta, não gerando nenhum projeto. É preciso o jdk instalado e colocar todos os arquivos em uma pasta e rodar
```
javac StickerApp.java
```
Se tudo der certo a compilação deve occorrer sem problemas. E depois rodar o aplicativo com 
```
java StikerApp
```
É preciso escolher entre três tipos de stickers a serem gerados: Filmes, Imagens da Nasa ou Linguagens. Faça a escolha dentro da classe StickerApp (Tipo.IMBD, Tipo.NASA ou Tipo.LING) e realizar a compilação novamente. Na Classe Urls eu faço uso de uma variável de ambiente que consiste na chave da api para acessar as imagens da Nasa. Gere uma variável de ambiente com a sua chave ou apensa use a chave DEMO_KEY para testes.

## Filmes:
<table>
    <tr>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/imbd_stickers/Pulp%20Fiction.png" width="300">
        </td>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/imbd_stickers/The%20Godfather.png" width="300">
        </td>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/imbd_stickers/The%20Lord%20of%20the%20Rings:%20The%20Fellowship%20of%20the%20Ring.png" width="300">
        </td>
    </tr>
</table>

## Nasa:
<table>
    <tr>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/nasa_stickers/2MASS%20J17554042%2B6551277.png" width="300">
        </td>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/nasa_stickers/A%20Filament%20in%20Monoceros.png" width="300">
        </td>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/nasa_stickers/A%20Picturesque%20Equinox%20Sunset.png" width="300">
        </td>
    </tr>
</table>

## Linguagens:
<table>
    <tr>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/linguagens_stickers/Java.png" width="300">
        </td>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/linguagens_stickers/Kotlin.png" width="300">
        </td>
        <td align="center">
            <img src="https://github.com/hebaja/stickers-app/blob/master/linguagens_stickers/C%23.png" width="300">
        </td>
    </tr>
</table>