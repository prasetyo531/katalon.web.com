# SauceDemo Katalon Tests

Proyek otomasi UI web untuk [SauceDemo](https://www.saucedemo.com/), dibuat dengan Katalon Studio 11.7.0. Test case ditulis dengan Groovy dan Katalon WebUI keywords; selector disimpan di Object Repository.

## Test Coverage

| Test case | Skenario | Hasil yang diharapkan |
|---|---|---|
| `TC_Login_StandardUser` | Login dengan akun demo standar | Berhasil masuk ke halaman Products |
| `TC_Login_LockedOutUser` | Login dengan akun demo yang terkunci | Login ditolak dengan pesan locked out |
| `TC_Checkout_Backpack` | Tambahkan Sauce Labs Backpack dan selesaikan checkout | Ringkasan harga benar dan halaman konfirmasi pesanan muncul |
| `TC_Cart_RemoveBackpack` | Tambahkan lalu hapus Sauce Labs Backpack dari keranjang | Badge keranjang hilang dan halaman cart tidak menampilkan item |

Semua case di atas dimasukkan ke suite `TS_SauceDemo_Smoke`.

## Struktur Folder

```text
SauceDemoKatalon/
├── SauceDemoKatalon.prj
├── README.md
├── build.gradle
├── console.properties
├── Profiles/
│   └── default.glbl
├── Test Cases/
│   └── Smoke/
│       ├── TC_Login_StandardUser.tc
│       ├── TC_Login_LockedOutUser.tc
│       ├── TC_Checkout_Backpack.tc
│       └── TC_Cart_RemoveBackpack.tc
├── Scripts/
│   └── Smoke/
│       ├── TC_Login_StandardUser/Script*.groovy
│       ├── TC_Login_LockedOutUser/Script*.groovy
│       ├── TC_Checkout_Backpack/Script*.groovy
│       └── TC_Cart_RemoveBackpack/Script*.groovy
├── Object Repository/
│   └── Pages/
│       ├── Login/
│       ├── Inventory/
│       ├── Cart/
│       └── Checkout/
├── Test Suites/
│   └── TS_SauceDemo_Smoke.ts
├── Keywords/
│   └── saucedemo/
│       └── LoginKeywords.groovy
├── Include/
│   └── config/
│       └── log.properties
├── settings/
│   ├── internal/
│   └── external/
├── Libs/                 # file internal yang dibuat Katalon
├── Reports/              # output eksekusi
├── .cache/               # cache/build hasil generate
├── bin/                  # output kompilasi
└── .gitignore
```

Folder opsional yang belum berisi file di proyek ini dapat dibuat saat diperlukan: `Data Files/` untuk CSV/Excel/JSON, `Drivers/` untuk driver browser lokal, `Checkpoints/` untuk checkpoint visual, `Test Listeners/` untuk hook sebelum/sesudah test, dan `Plugins/` untuk plugin Katalon.

## Fungsi Folder dan File

| Folder/file | Fungsi |
|---|---|
| `Test Cases/` | Metadata dan pengelompokan test case Katalon. File `.tc` dipasangkan dengan script Groovy yang lokasinya sama di bawah `Scripts/`. |
| `Scripts/` | Langkah otomatisasi untuk setiap test case. Nama folder harus sama dengan nama case; file script dikelola Katalon sebagai `Script*.groovy`. |
| `Object Repository/` | Selector elemen web dalam file `.rs`, dikelompokkan berdasarkan halaman. Gunakan object repository dari script dengan `findTestObject(...)`. |
| `Keywords/` | Keyword Groovy yang dapat dipakai ulang. Saat ini `saucedemo/LoginKeywords.groovy` membungkus proses login. |
| `Test Suites/` | File `.ts` yang mengelompokkan case untuk dijalankan bersama. Suite smoke proyek ini berisi empat test case di atas. |
| `Profiles/` | Variabel konfigurasi per environment. `default.glbl` menyimpan URL dan kredensial publik demo SauceDemo. |
| `Include/config/` | Konfigurasi logging proyek. |
| `settings/internal/`, `settings/external/` | Pengaturan internal proyek dan konfigurasi eksternal Katalon. Ubah melalui Project Settings di Studio jika memungkinkan. |
| `Libs/` | File internal/generated Katalon, termasuk dukungan Global Variables dan Custom Keywords. Jangan mengedit file generated secara manual. |
| `Reports/` | Log, laporan, screenshot, dan data self-healing dari eksekusi; hasil generate dan diabaikan Git. |
| `.cache/`, `bin/` | Cache dan hasil kompilasi Katalon; dibuat ulang oleh Studio dan diabaikan Git. |
| `SauceDemoKatalon.prj` | File utama untuk membuka proyek di Katalon Studio. |
| `build.gradle` | Konfigurasi build/dependency proyek Katalon. |
| `console.properties` | Konfigurasi mode console Katalon. |
| `.gitignore` | Mengecualikan file IDE, cache, output build, library internal, dan report dari Git. |

## Menjalankan Test di Katalon Studio

1. Buka Katalon Studio, lalu pilih **File > Open Project**.
2. Pilih file `SauceDemoKatalon.prj`.
3. Di Tests Explorer, buka **Test Suites > TS_SauceDemo_Smoke**.
4. Pilih Chrome lalu klik **Run**.
5. Periksa hasil tiap case di **Log Viewer**.

Tes menggunakan kredensial demo publik yang ditampilkan di halaman login SauceDemo. Data checkout (`Test User`, `12345`) adalah data contoh. Jangan gunakan kredensial pribadi atau production di proyek demo.

## How to Contribute

1. Buat branch untuk perubahan, misalnya `feature/TC-cart-empty-state`.
2. Untuk test case baru, buat metadata `.tc` di folder yang sesuai dan script pasangannya di `Scripts/<folder>/<nama-case>/Script*.groovy`. Buat test case dari Studio bila tersedia agar metadata Katalon tetap konsisten.
3. Simpan selector baru sebagai Test Object `.rs` di `Object Repository/Pages/<nama-halaman>/`. Pilih locator yang stabil seperti `data-test`, ID, atau atribut semantik; hindari XPath absolut.
4. Pindahkan alur berulang ke `Keywords/` bila dipakai oleh beberapa test case.
5. Tambahkan test case ke suite yang relevan di `Test Suites/`. Pastikan setiap case berdiri sendiri dan membersihkan browser di akhir.
6. Jika menambah atau mengubah skenario, perbarui tabel **Test Coverage** dan instruksi terkait di README.
7. Jalankan suite smoke di Katalon Studio dan periksa hasilnya di Log Viewer sebelum mengajukan perubahan.
8. Ajukan pull request dengan ringkasan perubahan, daftar skenario yang dijalankan, hasil eksekusi, serta versi Katalon Studio yang digunakan.

Jangan commit `bin/`, `.cache/`, `Reports/`, `Libs/`, atau file IDE yang dikecualikan oleh `.gitignore`.
