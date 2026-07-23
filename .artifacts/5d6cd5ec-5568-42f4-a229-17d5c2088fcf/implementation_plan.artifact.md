# Forbind til det nye GitHub repository (Eksamensprojekt1)

Dette projekt er i øjeblikket forbundet til et ældre repository (`EksamenProjekt`). Vi skal opdatere det til at pege på dit nye repository `Eksamensprojekt1` og uploade din kode.

## User Review Required

> [!IMPORTANT]
> Jeg antager, at URL'en til dit nye repository er `https://github.com/Niko192001/Eksamensprojekt1.git`. Bekræft venligst om dette er korrekt, eller oplys den rigtige URL.

## Proposed Changes

### Git Konfiguration

#### [MODIFY] Git Remote
Vi vil ændre `origin` til at pege på det nye repository.
```bash
git remote set-url origin https://github.com/Niko192001/Eksamensprojekt1.git
```

#### [MODIFY] [.gitignore](file:///Users/nikolajrahe/Documents/Documents/It-arkitektur - EK/2 Semester/NeverAnother-kopi/.gitignore)
Jeg foreslår at opdatere `.gitignore` for at undgå at uploade midlertidige filer som `.artifacts/` og unødvendige `.idea/` filer.

### commit og Push
1. Tilføj alle ændringer (`git add .`).
2. Lav en commit med en beskrivelse (f.eks. "Initial commit for Eksamensprojekt1").
3. Push koden til det nye repository (`git push -u origin main`).

## Verification Plan

### Manual Verification
- Jeg vil køre `git remote -v` for at bekræfte den nye URL.
- Jeg vil køre `git status` for at sikre, at alt er committed.
- Du skal tjekke GitHub for at se, om koden er kommet op.
