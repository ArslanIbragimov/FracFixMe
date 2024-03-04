module.exports = (env, argv) => ({
  entry: "./src/main/resources/js/app.js",
  output: {
    path: path.resolve(__dirname, "./target/classes/static"),
    filename: "js/bundle.js",
  },
  devtool: argv.mode === "production" ? false : "eval-source-map",
  optimization: {
    minimize: true,
    minimizer: [new TerserPlugin(), new CssMinimizerPlugin()],
  },
  plugins: [
    new MiniCssExtractPlugin({
      filename: "css/bundle.css",
    }),
    new WarningsToErrorsPlugin(),
  ],
  module: {
    rules: [
      {
        test: /\.js$'/,
        include: path.resolve(__dirname, "./src/main/resources/js"),
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env"],
          },
        },
      },
      // {
      //   test: /\.scss$/,
      //   include: path.resolve(__dirname, './src/main/resources/scss'),
      //   use: [
      //     argv.mode === 'production' ? MiniCssExtractPlugin.loader : 'style-loader',
      //     {
      //       loader: 'css-loader',
      //       options: {
      //         importLoaders: 1,
      //         sourceMap: true
      //       }
      //     },
      //     {
      //       loader: 'postcss-loader',
      //       options: {
      //         postcssOptions: {
      //           plugins: [
      //             require('autoprefixer'),
      //           ]
      //         },
      //         sourceMap: true
      //       }
      //     },
      //     {
      //       loader: 'sass-loader',
      //       options: { sourceMap: true }
      //     }
      //   ]
      // }
    ],
  },
  resolve: {
    modules: [path.resolve(__dirname, "./src/main/resources"), "node_modules"],
  },
  devServer: {
    port: 8081,
    compress: true,
    watchFiles: [
      "src/main/resources/templates/**/*.html",
      "src/main/resources/js/**/*.js",
      "src/main/resources/scss/**/*.scss",
    ],
    proxy: [
    //With this setup, the DevServer runs on port 8081 and forwards all requests that it cannot answer itself to our \
    //Spring Boot app on port 8080. We can start it with and because of the flag it will directly open in the browser when started. \
    //By defining the browser will reload automatically after every file change - here the HTML extension also includes our Thymeleaf templates. \
    //This works best by setting up hot reload for Thymeleaf.npm run devserver--openhttp://localhost:8081watchFiles
      {
        context: "**",
        target: "http://localhost:8080",
        secure: false,
        prependPath: false,
        headers: {
          "X-Devserver": "1",
        },
      },
    ],
  },
});
