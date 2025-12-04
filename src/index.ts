import { registerPlugin } from '@capacitor/core';

export interface SunmiPayload {
  action: string;
  data?: string;
  source_byte_base64?: string;
  [k: string]: any;
}

export interface SunmiBroadcastPlugin {
  addListener(
    eventName: 'sunmiScan',
    listener: (payload: SunmiPayload) => void
  ): Promise<{ remove: () => void }>;
}

export const SunmiBroadcast = registerPlugin<SunmiBroadcastPlugin>('SunmiBroadcast');
