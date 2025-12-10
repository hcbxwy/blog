# 后端项目设置下一个版本号
$projectRoot = Join-Path $PSScriptRoot ".."
$backendPath = Join-Path $projectRoot "backend"

Push-Location $backendPath

Write-Host "Set next version..." -ForegroundColor Yellow

mvn versions:set -DnextSnapshot -DprocessAllModules=true -DgenerateBackupPoms=false

Pop-Location
Write-Host "Success" -ForegroundColor Green