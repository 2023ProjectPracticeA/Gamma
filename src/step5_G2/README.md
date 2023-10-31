# `Complex` クラス

## 概要

`Complex` クラスは、複素数を表すクラスです。
実部、虚部のいずれかが `NaN` である場合、どちらも `NaN` になります。

## 設計

すべての計算を行うインスタンスメソッドは、静的メソッドを呼び出して処理を行います。
静的メソッドで実際の計算を行うことで副作用を起こしにくくしています。
インスタンスメソッドは、その静的メソッドを呼び出すだけなので、同じ処理を記述せずに済みます。

## メンバー変数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `real` | 実部を表す |
| `double` | `imag` | 虚部を表す |

## コンストラクター

### 概要

`Complex` クラスのコンストラクターです。

### オーバーロード

1. `Complex()`

    引数なしのコンストラクターです。
    実部と虚部を `0.0` で初期化します。

    #### 引数

    なし

2. `Complex(double real)`
        
    実部を引数で初期化します。虚部は `0.0` で初期化します。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実部を表す |

3. `Complex(double real, double imag)`
    
    実部と虚部を引数で初期化します。

    #### 引数
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実部を表す |
    | `double` | `imag` | 虚部を表す |

    
4. `Complex(Complex complex)`
    複製コンストラクターです。
    `complex` の実部と虚部を複製します。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | 複製元の `Complex` クラスのインスタンス |

### 戻り値

新しく作成された `Complex` クラスのインスタンス

### 使い方

```Java
// 実部と虚部を 0.0 で初期化
Complex c1 = new Complex();

// 実部を 1.0 で初期化
Complex c2 = new Complex(1.0);

// 実部を 1.0、虚部を 2.0 で初期化
Complex c3 = new Complex(1.0, 2.0);

// c2 の実部と虚部を複製
Complex c4 = new Complex(c2);
```

## `getReal` メソッド

### 概要

`Complex` クラスの実部を取得するメソッドです。

### 引数

なし

### 戻り値


| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 実部 |

### 使い方

```Java
Complex c = new Complex(1.0, 2.0);
// real に 1.0 が代入される
double real = c.getReal();
```

## `getImag` メソッド

### 概要

`Complex` クラスの虚部を取得するメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 虚部 |

### 使い方

```Java
Complex c = new Complex(1.0, 2.0);
// imag に 2.0 が代入される
double imag = c.getImag();
```

## `setReal` メソッド

### 概要

`Complex` クラスの実部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `real` | 実部 |

### 戻り値

なし

### 使い方

```Java
Complex c = new Complex();
c.setReal(1.0);
```

## `setImag` メソッド

### 概要

`Complex` クラスの虚部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `imag` | 虚部 |

### 戻り値

なし

### 使い方

```Java
Complex c = new Complex();
c.setImag(2.0);
```

## `set` メソッド

### 概要

`Complex` クラスの実部と虚部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `real` | 実部 |
| `double` | `imag` | 虚部 |

### 戻り値

なし

### 使い方

```Java
Complex c = new Complex();
c.set(1.0, 2.0);
```

## 静的 `plus` メソッド

### 概要

`Complex` クラスのインスタンスとの和を求める静的メソッドです。

### オーバーロード

1. `plus(double real, Complex complex)`

    実数 `real` と複素数 `complex` の和を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

2. `plus(Complex complex, double real)`

    複素数 `complex` と実数 `real` の和を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `plus(Complex complex1, Complex complex2)`

    複素数 `complex1` と複素数 `complex2` の和を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex1` | `Complex` クラスのインスタンス |
    | `Complex` | `complex2` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 和 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の和を求める
Complex c3 = Complex.plus(c1, c2);
```

## 静的 `minus` メソッド

### 概要

`Complex` クラスのインスタンスとの差を求める静的メソッドです。

### オーバーロード

1. `minus(double real, Complex complex)`

    実数 `real` と複素数 `complex` の差を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

2. `minus(Complex complex, double real)`
        
    複素数 `complex` と実数 `real` の差を求めます。
    
    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `minus(Complex complex1, Complex complex2)`

    複素数 `complex1` と複素数 `complex2` の差を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex1` | `Complex` クラスのインスタンス |
    | `Complex` | `complex2` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 差 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の差を求める
Complex c3 = Complex.minus(c1, c2);
```

## 静的 `times` メソッド

### 概要

`Complex` クラスのインスタンスとの積を求める静的メソッドです。

### オーバーロード

1. `times(double real, Complex complex)`

    実数 `real` と複素数 `complex` の積を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

2. `times(Complex complex, double real)`

    複素数 `complex` と実数 `real` の積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `times(Complex complex1, Complex complex2)`

    複素数 `complex1` と複素数 `complex2` の積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex1` | `Complex` クラスのインスタンス |
    | `Complex` | `complex2` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 積 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の積を求める
Complex c3 = Complex.times(c1, c2);
```

## 静的 `over` メソッド

### 概要

`Complex` クラスのインスタンスとの商を求める静的メソッドです。

### オーバーロード

1. `over(double real, Complex complex)`

    実数 `real` と複素数 `complex` の商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

2. `over(Complex complex, double real)`

    複素数 `complex` と実数 `real` の商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `over(Complex complex1, Complex complex2)`

    複素数 `complex1` と複素数 `complex2` の商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex1` | `Complex` クラスのインスタンス |
    | `Complex` | `complex2` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 商 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の商を求める
Complex c3 = Complex.over(c1, c2);
```

## `plus` メソッド

### 概要

和を求めるメソッドです。

### オーバーロード

1. `plus(double real)`

    実数 `real` との和を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `plus(Complex complex)`

    複素数 `complex` との和を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 和 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の和を求める
Complex c3 = c1.plus(c2);
```

## `minus` メソッド

### 概要

差を求めるメソッドです。

### オーバーロード

1. `minus(double real)`

    実数 `real` との差を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `minus(Complex complex)`

    複素数 `complex` との差を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 差 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の差を求める
Complex c3 = c1.minus(c2);
```

## `times` メソッド

### 概要

積を求めるメソッドです。

### オーバーロード

1. `times(double real)`

    実数 `real` との積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `times(Complex complex)`

    複素数 `complex` との積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 積 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の積を求める
Complex c3 = c1.times(c2);
```

## `over` メソッド

### 概要

商を求めるメソッドです。

### オーバーロード

1. `over(double real)`

    実数 `real` との商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `over(Complex complex)`

    複素数 `complex` との商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex` | `complex` | `Complex` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex` | 商 |

### 使い方

```Java
Complex c1 = new Complex(1.0, 2.0);
Complex c2 = new Complex(3.0, 4.0);

// c1 と c2 の商を求める
Complex c3 = c1.over(c2);
```

## 静的 `disp` メソッド

### 概要

複素数を標準出力する静的メソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `Complex` | `complex` | `Complex` クラスのインスタンス |

### 戻り値

なし

### 使い方

```Java
Complex c = new Complex(1.0, 2.0);
Complex.disp(c);
```

### 標準出力

```txt
1.0 + 2.0i
```

## `disp` メソッド

### 概要

複素数を標準出力するメソッドです。

### 引数

なし

### 戻り値

なし

### 使い方

```Java
Complex c = new Complex(1.0, 2.0);
c.disp();
```

### 標準出力

```txt
1.0 + 2.0i
```

# `Complex2` クラス

## 概要

`Complex2` クラスは、複素数の拡張を表す数を表すクラスです。
複素数は実部と 1 つの虚部で表されますが、複素数の拡張を表す数では、新たに 2 つの虚部を追加して、実部と 3 つの虚部で表されます。
実部またはいずれかの虚部が `NaN` である場合、すべて `NaN` になります。

## 設計

すべての計算を行うインスタンスメソッドは、静的メソッドを呼び出して処理を行います。
静的メソッドで実際の計算を行うことで副作用を起こしにくくしています。
インスタンスメソッドは、その静的メソッドを呼び出すだけなので、同じ処理を記述せずに済みます。

## メンバー変数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `real` | 実部を表す |
| `double` | `imag` | 第一虚部を表す |
| `double` | `j` | 第二虚部を表す |
| `double` | `k` | 第三虚部を表す |

## コンストラクター

### 概要

`Complex2` クラスのコンストラクターです。

### オーバーロード

1. `Complex2()`

    引数なしのコンストラクターです。
    実部とすべての虚部を `0.0` で初期化します。

    #### 引数

    なし

2. `Complex2(double real)`

    実部を引数で初期化します。すべての虚部は `0.0` で初期化します。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実部を表す |

3. `Complex2(double real, double imag)`

    実部と第一虚部を引数で初期化します。第二虚部と第三虚部は `0.0` で初期化します。

    #### 引数
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実部を表す |
    | `double` | `imag` | 第一虚部を表す |

4. `Complex2(double real, double imag, double j, double k)`

    実部と第一虚部と第二虚部と第三虚部を引数で初期化します。

    #### 引数
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実部を表す |
    | `double` | `imag` | 第一虚部を表す |
    | `double` | `j` | 第二虚部を表す |
    | `double` | `k` | 第三虚部を表す |

5. `Complex2(Complex2 complex)`

    複製コンストラクターです。
    `complex` の実部と虚部を複製します。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | 複製元の `Complex2` クラスのインスタンス |

### 戻り値

新しく作成された `Complex2` クラスのインスタンス

### 使い方

```Java
// 実部とすべての虚部を 0.0 で初期化
Complex2 c1 = new Complex2();

// 実部を 1.0 で初期化
Complex2 c2 = new Complex2(1.0);

// 実部を 1.0、第一虚部を 2.0 で初期化
Complex2 c3 = new Complex2(1.0, 2.0);

// 実部を 1.0、第一虚部を 2.0、第二虚部を 3.0、第三虚部を 4.0 で初期化
Complex2 c4 = new Complex2(1.0, 2.0, 3.0, 4.0);

// c2 の実部とすべての虚部を複製
Complex2 c5 = new Complex2(c2);
```

## `getReal` メソッド

### 概要

`Complex2` クラスの実部を取得するメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 実部 |

### 使い方

```Java
Complex2 c = new Complex2(1.0, 2.0, 3.0, 4.0);
// real に 1.0 が代入される
double real = c.getReal();
```

## `getImag` メソッド

### 概要

`Complex2` クラスの第一虚部を取得するメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 第一虚部 |

### 使い方

```Java
Complex2 c = new Complex2(1.0, 2.0, 3.0, 4.0);
// imag に 2.0 が代入される
double imag = c.getImag();
```

## `getJ` メソッド

### 概要

`Complex2` クラスの第二虚部を取得するメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 第二虚部 |

### 使い方

```Java
Complex2 c = new Complex2(1.0, 2.0, 3.0, 4.0);
// j に 3.0 が代入される
double j = c.getJ();
```

## `getK` メソッド

### 概要

`Complex2` クラスの第三虚部を取得するメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 第三虚部 |

### 使い方

```Java
Complex2 c = new Complex2(1.0, 2.0, 3.0, 4.0);
// k に 4.0 が代入される
double k = c.getK();
```

## `setReal` メソッド

### 概要

`Complex2` クラスの実部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `real` | 実部 |

### 戻り値

なし

### 使い方

```Java
Complex2 c = new Complex2();
c.setReal(1.0);
```

## `setImag` メソッド

### 概要

`Complex2` クラスの第一虚部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `imag` | 第一虚部 |

### 戻り値

なし

### 使い方

```Java
Complex2 c = new Complex2();
c.setImag(2.0);
```

## `setJ` メソッド

### 概要

`Complex2` クラスの第二虚部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `j` | 第二虚部 |

### 戻り値

なし

### 使い方

```Java
Complex2 c = new Complex2();
c.setJ(3.0);
```

## `setK` メソッド

### 概要

`Complex2` クラスの第三虚部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `k` | 第三虚部 |

### 戻り値

なし

### 使い方

```Java
Complex2 c = new Complex2();
c.setK(4.0);
```

## `setComplex` メソッド

### 概要

`Complex2` クラスの実部と第一虚部を設定するメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `double` | `real` | 実部 |
| `double` | `imag` | 第一虚部 |

### 戻り値

なし

### 使い方

```Java
Complex2 c = new Complex2();
c.setComplex(1.0, 2.0);
```

## `set` メソッド

### 概要

`Complex2` クラスの実部と第一虚部と第二虚部と第三虚部を設定するメソッドです。

### オーバーロード

1. `set(double real, double imag, double j, double k)`

    実部と第一虚部と第二虚部と第三虚部を設定します。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実部 |
    | `double` | `imag` | 第一虚部 |
    | `double` | `j` | 第二虚部 |
    | `double` | `k` | 第三虚部 |

2. `set(Complex2 complex)`

    `complex` の実部と虚部を複製します。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | 複製元の `Complex2` クラスのインスタンス |

### 戻り値

なし

### 使い方

```Java
Complex2 c = new Complex2();
c.set(1.0, 2.0, 3.0, 4.0);
```

## 静的 `plus` メソッド

### 概要

`Complex2` クラスのインスタンスとの和を求める静的メソッドです。

### オーバーロード

1. `plus(double real, Complex2 complex)`

    実数 `real` と複素数の拡張を表す数 `complex` の和を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

2. `plus(Complex2 complex, double real)`

    複素数の拡張を表す数 `complex` と実数 `real` の和を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `plus(Complex2 complex1, Complex2 complex2)`

    複素数の拡張を表す数 `complex1` と複素数の拡張を表す数 `complex2` の和を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex1` | `Complex2` クラスのインスタンス |
    | `Complex2` | `complex2` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 和 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の和を求める
Complex2 c3 = Complex2.plus(c1, c2);
```

## 静的 `minus` メソッド

### 概要

`Complex2` クラスのインスタンスとの差を求める静的メソッドです。

### オーバーロード

1. `minus(double real, Complex2 complex)`

    実数 `real` と複素数の拡張を表す数 `complex` の差を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

2. `minus(Complex2 complex, double real)`

    複素数の拡張を表す数 `complex` と実数 `real` の差を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `minus(Complex2 complex1, Complex2 complex2)`

    複素数の拡張を表す数 `complex1` と複素数の拡張を表す数 `complex2` の差を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex1` | `Complex2` クラスのインスタンス |
    | `Complex2` | `complex2` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 差 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の差を求める
Complex2 c3 = Complex2.minus(c1, c2);
```

## 静的 `times` メソッド

### 概要

`Complex2` クラスのインスタンスとの積を求める静的メソッドです。
複素数を表す `Complex` クラスと異なり、計算の順序が変わると結果が変わるので、注意してください。

### オーバーロード

1. `times(double real, Complex2 complex)`

    実数 `real` と複素数の拡張を表す数 `complex` の積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

2. `times(Complex2 complex, double real)`

    複素数の拡張を表す数 `complex` と実数 `real` の積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `times(Complex2 complex1, Complex2 complex2)`

    複素数の拡張を表す数 `complex1` と複素数の拡張を表す数 `complex2` の積を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex1` | `Complex2` クラスのインスタンス |
    | `Complex2` | `complex2` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 積 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の積を求める
Complex2 c3 = Complex2.times(c1, c2);
```

## 静的 `over` メソッド

### 概要

`Complex2` クラスのインスタンスとの商を求める静的メソッドです。
実際には、逆数を求めてから積を求めています。

### オーバーロード

1. `over(double real, Complex2 complex)`

    実数 `real` と複素数の拡張を表す数 `complex` の商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

2. `over(Complex2 complex, double real)`

    複素数の拡張を表す数 `complex` と実数 `real` の商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |
    | `double` | `real` | 実数 |

3. `over(Complex2 complex1, Complex2 complex2)`

    複素数の拡張を表す数 `complex1` と複素数の拡張を表す数 `complex2` の商を求めます。

    #### 引数
    
    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex1` | `Complex2` クラスのインスタンス |
    | `Complex2` | `complex2` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 商 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の商を求める
Complex2 c3 = Complex2.over(c1, c2);
```

## `plus` メソッド

### 概要

`Complex2` クラスのインスタンスとの和を求めるメソッドです。

### オーバーロード

1. `plus(double real)`

    実数 `real` との和を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `plus(Complex2 complex)`

    複素数の拡張を表す数 `complex` との和を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 和 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の和を求める
Complex2 c3 = c1.plus(c2);
```

## `minus` メソッド

### 概要

`Complex2` クラスのインスタンスとの差を求めるメソッドです。

### オーバーロード

1. `minus(double real)`

    実数 `real` との差を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `minus(Complex2 complex)`

    複素数の拡張を表す数 `complex` との差を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 差 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の差を求める
Complex2 c3 = c1.minus(c2);
```

## `times` メソッド

### 概要

`Complex2` クラスのインスタンスとの積を求めるメソッドです。
複素数を表す `Complex` クラスと異なり、計算の順序が変わると結果が変わるので、注意してください。

### オーバーロード

1. `times(double real)`

    実数 `real` との積を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `times(Complex2 complex)`

    複素数の拡張を表す数 `complex` との積を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 積 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の積を求める
Complex2 c3 = c1.times(c2);
```

## `over` メソッド

### 概要

`Complex2` クラスのインスタンスとの商を求めるメソッドです。
実際には、逆数を求めてから積を求めています。

### オーバーロード

1. `over(double real)`

    実数 `real` との商を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `double` | `real` | 実数 |

2. `over(Complex2 complex)`

    複素数の拡張を表す数 `complex` との商を求めます。

    #### 引数

    | 型 | 変数名 | 概要 |
    |:---:|:---:|:---:|
    | `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 商 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の商を求める
Complex2 c3 = c1.over(c2);
```

## 静的 `conj` メソッド

### 概要

`Complex2` クラスのインスタンスの共役を求める静的メソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 複素数の拡張を表す数の共役 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);

// c1 の共役を求める
Complex2 c2 = Complex2.conj(c1);
```

## `conj` メソッド

### 概要

`Complex2` クラスのインスタンスの共役を求めるメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `Complex2` | 複素数の拡張を表す数の共役 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);

// c1 の共役を求める
Complex2 c2 = c1.conj();
```

## 静的 `abs` メソッド

### 概要

`Complex2` クラスのインスタンスの絶対値を求める静的メソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 絶対値 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);

// c1 の絶対値を求める
double abs = Complex2.abs(c1);
```

## `abs` メソッド

### 概要

`Complex2` クラスのインスタンスの絶対値を求めるメソッドです。

### 引数

なし

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 絶対値 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);

// c1 の絶対値を求める
double abs = c1.abs();
```

## 静的 `dot` メソッド

### 概要

`Complex2` クラスのインスタンスの内積を求める静的メソッドです。

### 引数
    
| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `Complex2` | `complex1` | `Complex2` クラスのインスタンス |
| `Complex2` | `complex2` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 内積 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の内積を求める
double dot = Complex2.dot(c1, c2);
```

## `dot` メソッド

### 概要

`Complex2` クラスのインスタンスの内積を求めるメソッドです。

### 引数

| 型 | 変数名 | 概要 |
|:---:|:---:|:---:|
| `Complex2` | `complex` | `Complex2` クラスのインスタンス |

### 戻り値

| 戻り値の型 | 説明 |
|:---:|:---:|
| `double` | 内積 |

### 使い方

```Java
Complex2 c1 = new Complex2(1.0, 2.0, 3.0, 4.0);
Complex2 c2 = new Complex2(5.0, 6.0, 7.0, 8.0);

// c1 と c2 の内積を求める
double dot = c1.dot(c2);
```

## 静的 `args` メソッド

### 概要

`Complex2` クラスのインスタンスを複素数をとみなして偏角を求める静的メソッドです。
