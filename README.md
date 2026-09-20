# Haushaltsbudget

Eine kleine, werbefreie Haushaltsbudget-App: monatliches Einkommen eintragen,
Ausgaben nach Kategorien erfassen, der Rest wird automatisch berechnet.
Es gibt außerdem eine Jahresübersicht mit dem Rest pro Monat. Alle Daten
werden nur lokal auf dem Gerät gespeichert (`localStorage`), es gibt keinen
Server und keine Datenübertragung.

- **`index.html`** – die eigentliche App (einzige Quelle für den Inhalt).
  Kann direkt im Browser geöffnet oder als Webseite gehostet werden.
- **`android/`** – ein minimales natives Android-Projekt, das `index.html`
  in einer WebView anzeigt, um daraus eine installierbare **APK** zu bauen.

## APK bekommen

Diese Umgebung hier kann selbst keine APK bauen (kein Android SDK verfügbar),
aber GitHub Actions baut sie automatisch:

1. Diesen Branch/PR nach GitHub pushen (bzw. den vorhandenen Workflow-Lauf abwarten).
2. Im Tab **Actions** den Workflow **"Android APK bauen"** öffnen.
3. Im aktuellsten Lauf ganz unten unter **Artifacts** die Datei
   `haushaltsbudget-debug-apk` herunterladen und entpacken (`app-debug.apk`).
4. Die `app-debug.apk` auf das Android-Handy übertragen und öffnen.
   Android fragt evtl. nach Erlaubnis, "Apps aus unbekannten Quellen" zu
   installieren – das einmal bestätigen, dann installiert sich die App.

Der Workflow lässt sich auch manuell anstoßen: Actions → "Android APK bauen"
→ "Run workflow".

## Lokal bauen (falls Android SDK vorhanden ist)

```bash
cd android
./gradlew assembleDebug
```

Die fertige APK liegt danach unter `android/app/build/outputs/apk/debug/app-debug.apk`.

## App-Inhalt ändern

Einfach `index.html` im Projekt-Root bearbeiten. Beim nächsten APK-Build wird
sie automatisch unverändert in die Android-App übernommen – es gibt keine
zweite Kopie, die man synchron halten müsste.
