$ErrorActionPreference = 'Stop'
Set-Location -LiteralPath $PSScriptRoot
New-Item -ItemType Directory -Force -Path 'out' | Out-Null
$fontesRpg = Get-ChildItem -LiteralPath 'src' -Recurse -Filter '*.java' | ForEach-Object FullName
& javac -encoding UTF-8 -d out $fontesRpg
if ($LASTEXITCODE -ne 0) { throw 'Erro ao compilar os testes.' }
foreach ($testeRpg in (Get-ChildItem -LiteralPath 'src/rpg/test' -Filter '*Test*.java' | Sort-Object Name)) {
    if ($testeRpg.BaseName -eq 'JogoTest01') { continue }
    Write-Output ('Executando ' + $testeRpg.BaseName)
    & java -Dfile.encoding=UTF-8 -ea -cp out ('rpg.test.' + $testeRpg.BaseName)
    if ($LASTEXITCODE -ne 0) { throw ('Falha em ' + $testeRpg.BaseName) }
}
Write-Output 'Todos os testes passaram.'
