import { registerPlugin } from '@capacitor/core';

import type { SunmiBroadcastPlugin } from './definitions';

const SunmiBroadcast = registerPlugin<SunmiBroadcastPlugin>('SunmiBroadcast', {
  web: () => import('./web').then((m) => new m.SunmiBroadcastWeb()),
});

export * from './definitions';
export { SunmiBroadcast };
