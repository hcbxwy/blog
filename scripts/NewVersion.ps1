# 后端项目设置指定版本号
$projectRoot = Join-Path $PSScriptRoot ".."
$backendPath = Join-Path $projectRoot "backend"

$NewVersion = Read-Host "Please enter new version"

Push-Location $backendPath

Write-Host "Set new version..." -ForegroundColor Yellow

mvn versions:set "-DnewVersion=$NewVersion" -DprocessAllModules=true -DgenerateBackupPoms=false

Pop-Location
Write-Host "Success" -ForegroundColor Green