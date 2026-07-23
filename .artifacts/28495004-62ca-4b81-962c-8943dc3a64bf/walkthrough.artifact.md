# "Need to Have" Forbedringer Gennemført

Jeg har nu implementeret de vigtigste forbedringer for at gøre jeres app mere robust, brugervenlig og velstruktureret.

## Ændringer Foretaget

### 1. Centraliseret Farve-styring (Farve-oprydning)
Alle jeres gennemgående farver er nu flyttet til [Color.kt](file:///Users/nikolajrahe/Documents/Documents/It-arkitektur%20-%20EK/2%20Semester/NeverAnother/app/src/main/java/com/example/neveranother/ui/theme/Color.kt).
- **Farver flyttet**: `BackgroundColor`, `Burgundy` og `LightCircle`.
- **Fordel**: I skal nu kun rette farven ét sted, hvis I vil ændre appens udseende. Alle filer (navbar, skærme, komponenter) henter nu farverne herfra.

### 2. Bedre Brugeroplevelse i Kurven ([KurvScreen.kt](file:///Users/nikolajrahe/Documents/Documents/It-arkitektur%20-%20EK/2%20Semester/NeverAnother/app/src/main/java/com/example/neveranother/screens/KurvScreen.kt))
- **Hukommelse ved rotation**: Jeg har skiftet til `rememberSaveable`. Det betyder, at hvis brugeren vender telefonen midt i indtastningen, bliver deres data ikke slettet.
- **Tastatur-styring**: Jeg har tilføjet `KeyboardOptions`. Tastaturet viser nu en "Næste"-knap, der hopper direkte til næste felt, og den vælger selv det rigtige tastatur (f.eks. tal til telefonnummer).
- **Validering**: "Fortsæt"-knappen er nu deaktiveret (grå), indtil brugeren har udfyldt Fornavn, Efternavn, en gyldig E-mail (skal indeholde @) og Adresse.

## Verificering

### Automatiseret Test
- Projektet er blevet bygget med `./gradlew :app:compileDebugKotlin`, og det byggede fejlfrit.

### Manuel Test Anbefales
1. Åbn Kurv-skærmen.
2. Prøv at skrive noget i et felt og vend telefonen – teksten skal blive stående.
3. Brug "Næste"-knappen på tastaturet til at udfylde formularen.
4. Tjek at knappen i bunden først bliver rød (aktiv), når de vigtigste felter er udfyldt korrekt.
