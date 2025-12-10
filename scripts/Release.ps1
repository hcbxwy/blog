# 后端项目发布版本：移除 SNAPSHOT
$projectRoot = Join-Path $PSScriptRoot ".."
$backendPath = Join-Path $projectRoot "backend"

Push-Location $backendPath

Write-Host "Start Release (remove SNAPSHOT)..." -ForegroundColor Yellow

mvn versions:set -DremoveSnapshot -DprocessAllModules=true -DgenerateBackupPoms=false

Pop-Location
Write-Host "Success" -ForegroundColor Green