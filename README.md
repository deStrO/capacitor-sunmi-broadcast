# capacitor-sunmi-broadcast

Use broadcast

## Install

```bash
npm install capacitor-sunmi-broadcast
npx cap sync
```

## API

<docgen-index>

* [`addListener('sunmiScan', ...)`](#addlistenersunmiscan-)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### addListener('sunmiScan', ...)

```typescript
addListener(eventName: 'sunmiScan', listener: (payload: SunmiPayload) => void) => Promise<{ remove: () => void; }>
```

| Param           | Type                                                                        |
| --------------- | --------------------------------------------------------------------------- |
| **`eventName`** | <code>'sunmiScan'</code>                                                    |
| **`listener`**  | <code>(payload: <a href="#sunmipayload">SunmiPayload</a>) =&gt; void</code> |

**Returns:** <code>Promise&lt;{ remove: () =&gt; void; }&gt;</code>

--------------------


### Interfaces


#### SunmiPayload

| Prop                     | Type                |
| ------------------------ | ------------------- |
| **`action`**             | <code>string</code> |
| **`data`**               | <code>string</code> |
| **`source_byte_base64`** | <code>string</code> |

</docgen-api>
