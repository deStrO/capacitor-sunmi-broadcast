import { WebPlugin } from '@capacitor/core';

import type { SunmiBroadcastPlugin } from './definitions';

export class SunmiBroadcastWeb extends WebPlugin implements SunmiBroadcastPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
