$ErrorActionPreference = 'Stop'
Set-Location -LiteralPath $PSScriptRoot
New-Item -ItemType Directory -Force -Path 'out' | Out-Null
$fontesRpg = Get-ChildItem -LiteralPath 'src' -Recurse -Filter '*.java' | ForEach-Object FullName
& javac -encoding UTF-8 -d out $fontesRpg
if ($LASTEXITCODE -ne 0) { throw 'Erro ao compilar o jogo.' }
& java -Dfile.encoding=UTF-8 -cp out rpg.test.JogoTest01
