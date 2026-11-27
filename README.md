# Nippy Client

Zimniy client na Fabric (Minecraft 1.21.11): custom UI s fioletovym akcentom,
50 modulei, quick-menu po Right Shift, wallpapery i optimizacii.

## Sborka lok
```
gradle build
```
JAR poyavitsya v `build/libs/`.

## Sborka cherez GitHub Actions
1. Zaley proekt na GitHub.
2. Actions sam sobirayet JAR pri kazhdom pushe v main.
3. Skachivay artefakt `nippy-client-jar` vo vkladke Actions.

## Vazhno
- Versii fabric-api i yarn v `gradle.properties` sver pered sborkoi na fabricmc.net/develop.
- Imena metodov v mixinakh proveryay na mappiingakh 1.21.11 (Yarn).
- Wallpapery lezhat v `assets/nippy/textures/gui/wallpapers/`.
