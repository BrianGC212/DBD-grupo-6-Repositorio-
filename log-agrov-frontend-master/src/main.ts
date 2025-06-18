// LOGISTICA_AGROVISION/log-agrov-frontend/src/main.ts

import 'zone.js'; // <-- ¡Asegúrate de que esta línea esté presente!

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app'; // <-- Importar AppModule desde app.ts

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
