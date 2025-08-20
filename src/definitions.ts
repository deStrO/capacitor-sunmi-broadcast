export interface SunmiBroadcastPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
