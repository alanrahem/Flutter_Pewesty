


flutter_colorpicker: any     //  پاکێج


import 'dart:ui';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';

class Setting extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _MyAppState();
}

class _MyAppState extends State<Setting> {
  bool lightTheme = true;
  Color currentColor = Colors.white;

  void changeColor(Color color) => setState(() => currentColor = color);

  @override
  Widget build(BuildContext context) {
    return Theme(
      data: lightTheme ? ThemeData.light() : ThemeData.dark(),
      child: Scaffold(
        appBar: AppBar(
          backgroundColor: currentColor,
        ),
        body: Center(
          child: Column(
           mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
            RaisedButton(
              elevation: 3.0,
              onPressed: () {
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      titlePadding: const EdgeInsets.all(0.0),
                      contentPadding: const EdgeInsets.all(0.0),
                      content: SingleChildScrollView(
                        child: ColorPicker(
                          pickerColor: currentColor,
                          onColorChanged: changeColor,
                          colorPickerWidth: 300.0,
                          pickerAreaHeightPercent: 0.7,
                          enableAlpha: true,
                          displayThumbColor: true,
                          showLabel: true,
                          paletteType: PaletteType.hsv,
                          pickerAreaBorderRadius: const BorderRadius.only(
                            topLeft: const Radius.circular(2.0),
                            topRight: const Radius.circular(2.0),
                          ),
                        ),
                      ),
                    );
                  },
                );
              },
              child: const Text('Change me'),
              color: currentColor,
              textColor: useWhiteForeground(currentColor)
                  ? const Color(0xffffffff)
                  : const Color(0xff000000),
            ),
            RaisedButton(
              elevation: 3.0,
              onPressed: () {
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      titlePadding: const EdgeInsets.all(0.0),
                      contentPadding: const EdgeInsets.all(0.0),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(25.0),
                      ),
                      content: SingleChildScrollView(
                        child: SlidePicker(
                          pickerColor: currentColor,
                          onColorChanged: changeColor,
                          paletteType: PaletteType.rgb,
                          enableAlpha: false,
                          displayThumbColor: true,
                          showLabel: false,
                          showIndicator: true,
                          indicatorBorderRadius:
                          const BorderRadius.vertical(
                            top: const Radius.circular(25.0),
                          ),
                        ),
                      ),
                    );
                  },
                );
              },
              child: const Text('Change me again'),
              color: currentColor,
              textColor: useWhiteForeground(currentColor)
                  ? const Color(0xffffffff)
                  : const Color(0xff000000),
            ),
            RaisedButton(
              elevation: 3.0,
              onPressed: () {
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      titlePadding: const EdgeInsets.all(0.0),
                      contentPadding: const EdgeInsets.all(0.0),
                      content: SingleChildScrollView(
                        child: MaterialPicker(
                          pickerColor: currentColor,
                          onColorChanged: changeColor,
                          enableLabel: true,
                        ),
                      ),
                    );
                  },
                );
              },
              child: const Text('Change me'),
              color: currentColor,
              textColor: useWhiteForeground(currentColor)
                  ? const Color(0xffffffff)
                  : const Color(0xff000000),
            ),
            RaisedButton(
              elevation: 3.0,
              onPressed: () {
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: Text('Select a color'),
                      content: SingleChildScrollView(
                        child: BlockPicker(
                          pickerColor: currentColor,
                          onColorChanged: changeColor,
                        ),
                      ),
                    );
                  },
                );
              },
              child: const Text('Change me'),
              color: currentColor,
              textColor: useWhiteForeground(currentColor)
                  ? const Color(0xffffffff)
                  : const Color(0xff000000),
            ),
          ],
         ),
        ),
      ),
    );
  }
}