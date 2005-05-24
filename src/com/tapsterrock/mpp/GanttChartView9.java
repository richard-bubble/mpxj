/*
 * file:       GanttChartView9.java
 * author:     Jon Iles
 * copyright:  (c) Tapster Rock Limited 2005
 * date:       Apr 7, 2005
 */
 
/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package com.tapsterrock.mpp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents the set of properties used to define the appearance
 * of a Gantt chart view in MS Project.
 */
public class GanttChartView9 extends View9
{
   /**
    * Create a GanttChartView from the dixed and var data blocks associated 
    * with a view.
    * 
    * @param parent parent MPP file
    * @param fixedData fixed data block
    * @param varData var data block
    * @throws IOException
    */
   public GanttChartView9 (MPPFile parent, byte[] fixedData, Var2Data varData)
      throws IOException
   {
      super (fixedData);
      
      m_parent = parent;
            
      byte[] propsData = varData.getByteArray(m_id, PROPERTIES);
      if (propsData != null)
      {
         Props9 props = new Props9(new ByteArrayInputStream(propsData));      
         //System.out.println (props);
         
         byte[] tableData = props.getByteArray(TABLE_PROPERTIES);
         if (tableData != null)
         {
            m_tableWidth = MPPUtility.getShort(tableData, 35);
         }

         byte[] tableName = props.getByteArray(TABLE_NAME);
         if (tableName != null)
         {
            m_tableName = MPPUtility.removeAmpersands(MPPUtility.getUnicodeString(tableName));
         }
         
         byte[] viewPropertyData = props.getByteArray(VIEW_PROPERTIES);   
         if (viewPropertyData != null)
         {
            m_highlightedTasksFontStyle = getFontStyle(viewPropertyData, 26);
            m_rowAndColumnFontStyle = getFontStyle(viewPropertyData, 30);
            m_nonCriticalTasksFontStyle = getFontStyle(viewPropertyData, 34);
            m_criticalTasksFontStyle = getFontStyle(viewPropertyData, 38);
            m_summaryTasksFontStyle = getFontStyle(viewPropertyData, 42);
            m_milestoneTasksFontStyle = getFontStyle(viewPropertyData, 46);
            m_majorTimescaleFontStyle = getFontStyle(viewPropertyData, 50);
            m_minorTimescaleFontStyle = getFontStyle(viewPropertyData, 54);
            m_barTextLeftFontStyle = getFontStyle(viewPropertyData, 58);
            m_barTextRightFontStyle = getFontStyle(viewPropertyData, 62);
            m_barTextTopFontStyle = getFontStyle(viewPropertyData, 66);
            m_barTextBottomFontStyle = getFontStyle(viewPropertyData, 70);
            m_barTextInsideFontStyle = getFontStyle(viewPropertyData, 74);
            m_markedTasksFontStyle = getFontStyle(viewPropertyData, 78);
            m_projectSummaryTasksFontStyle = getFontStyle(viewPropertyData, 82);
            m_externalTasksFontStyle = getFontStyle(viewPropertyData, 86);
            
            m_sheetRowsGridLines = new GridLines(viewPropertyData, 99);
            m_sheetColumnsGridLines = new GridLines(viewPropertyData, 109);
            m_titleVerticalGridLines = new GridLines(viewPropertyData, 119);
            m_titleHorizontalGridLines = new GridLines(viewPropertyData, 129);
            m_majorColumnsGridLines = new GridLines(viewPropertyData, 139);
            m_minorColumnsGridLines = new GridLines(viewPropertyData, 149);
            m_ganttRowsGridLines = new GridLines(viewPropertyData, 159);
            m_barRowsGridLines = new GridLines(viewPropertyData, 169);
            m_currentDateGridLines = new GridLines(viewPropertyData, 179);
            m_pageBreakGridLines = new GridLines(viewPropertyData, 189);
            m_projectStartGridLines = new GridLines(viewPropertyData, 199);
            m_projectFinishGridLines = new GridLines(viewPropertyData, 209);
            m_statusDateGridLines = new GridLines(viewPropertyData, 219);
            
            m_nonWorkingDaysCalendarName = MPPUtility.getUnicodeString(viewPropertyData, 352);
            m_nonWorkingColor = ColorType.getInstance(viewPropertyData[1153]);
            m_nonWorkingPattern = viewPropertyData[1154];
            m_nonWorkingStyle = NonWorkingTimeStyle.getInstance(viewPropertyData[1152]);
                        
            m_ganttBarHeight = mapGanttBarHeight(MPPUtility.getByte(viewPropertyData, 1163));
            
            byte flags = viewPropertyData[228];
            
            m_timescaleMiddleTier = new TimescaleTier ();
            m_timescaleMiddleTier.setTickLines((flags & 0x01) != 0);
            m_timescaleMiddleTier.setUsesFiscalYear((flags & 0x08) != 0);
            m_timescaleMiddleTier.setUnits(TimescaleUnits.getInstance(viewPropertyData[242]));
            m_timescaleMiddleTier.setCount(viewPropertyData[246]);
            m_timescaleMiddleTier.setFormat(viewPropertyData[250]);
            m_timescaleMiddleTier.setAlignment(TimescaleAlignment.getInstance(viewPropertyData[256]-32));
            
            m_timescaleBottomTier = new TimescaleTier ();
            m_timescaleBottomTier.setTickLines((flags & 0x02) != 0);
            m_timescaleBottomTier.setUsesFiscalYear((flags & 0x10) != 0);
            m_timescaleBottomTier.setUnits(TimescaleUnits.getInstance(viewPropertyData[244]));
            m_timescaleBottomTier.setCount(viewPropertyData[248]);
            m_timescaleBottomTier.setFormat(viewPropertyData[252]);            
            m_timescaleBottomTier.setAlignment(TimescaleAlignment.getInstance(viewPropertyData[254]-32));            
            
            m_timescaleSeparator = (flags & 0x04) != 0;            
            m_timescaleSize = viewPropertyData[268];

            m_showDrawings = (viewPropertyData[1156] != 0);
            m_roundBarsToWholeDays = (viewPropertyData[1158] != 0);
            m_showBarSplits = (viewPropertyData[1160] != 0);
            m_alwaysRollupGanttBars = (viewPropertyData[1186] != 0);
            m_hideRollupBarsWhenSummaryExpanded = (viewPropertyData[1188] != 0);
            m_barDateFormat = viewPropertyData[1182];
            m_linkStyle = LinkStyle.getInstance(viewPropertyData[1155]);
                        
            m_barStyles = new GanttBarStyle[viewPropertyData[1162]];
            int styleOffset = 1190;
            int nameOffset = styleOffset + (m_barStyles.length * 58);
            String styleName;
            
            for (int loop=0; loop < m_barStyles.length; loop++)
            {
               styleName = MPPUtility.getUnicodeString(viewPropertyData, nameOffset);
               nameOffset += (styleName.length()+1)*2;               
               m_barStyles[loop] = new GanttBarStyle(styleName, viewPropertyData, styleOffset);
               styleOffset += 58;
            }            
         }
         
         byte[] topTierData = props.getByteArray(TOP_TIER_PROPERTIES);         
         if (topTierData != null)
         {
            m_timescaleTopTier = new TimescaleTier ();            
            
            m_timescaleTopTier.setTickLines(topTierData[48]!=0);
            m_timescaleTopTier.setUsesFiscalYear(topTierData[60]!=0);
            m_timescaleTopTier.setUnits(TimescaleUnits.getInstance(topTierData[30]));
            m_timescaleTopTier.setCount(topTierData[32]);
            m_timescaleTopTier.setFormat(topTierData[34]);            
            m_timescaleTopTier.setAlignment(TimescaleAlignment.getInstance(topTierData[36]-20));                        
         }    

         byte[] barData = props.getByteArray(BAR_PROPERTIES);
         if (barData != null)
         {
            m_barStyleExceptions = new GanttBarStyleException[barData.length/38];
            int offset = 0;
            for (int loop=0; loop < m_barStyleExceptions.length; loop++)
            {
               m_barStyleExceptions[loop] = new GanttBarStyleException(barData, offset);
               offset += 38;
            }            
         }
      }                                          
   }

   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */
   public GridLines getSheetColumnsGridLines()
   {
      return (m_sheetColumnsGridLines);
   }

   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */   
   public GridLines getSheetRowsGridLines()
   {
      return (m_sheetRowsGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */   
   public GridLines getStatusDateGridLines()
   {
      return (m_statusDateGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */   
   public GridLines getTitleHorizontalGridLines()
   {
      return (m_titleHorizontalGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */   
   public GridLines getTitleVerticalGridLines()
   {
      return (m_titleVerticalGridLines);
   }

   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getBarRowsGridLines()
   {
      return (m_barRowsGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */   
   public GridLines getCurrentDateGridLines()
   {
      return (m_currentDateGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getGanttRowsGridLines()
   {
      return (m_ganttRowsGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getMajorColumnsGridLines()
   {
      return (m_majorColumnsGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getMinorColumnsGridLines()
   {
      return (m_minorColumnsGridLines);
   }
   
   /**
    * Retrieve the name of the calendar used to define non-working days for
    * this view..
    * 
    * @return calendar name
    */      
   public String getNonWorkingDaysCalendarName()
   {
      return (m_nonWorkingDaysCalendarName);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getPageBreakGridLines()
   {
      return (m_pageBreakGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getProjectFinishGridLines()
   {
      return (m_projectFinishGridLines);
   }
   
   /**
    * Retrieve a grid lines definition.
    * 
    * @return grid lines definition
    */      
   public GridLines getProjectStartGridLines()
   {
      return (m_projectStartGridLines);
   }
   
   /**
    * Retrieve the height of the Gantt bars in this view.
    * 
    * @return Gantt bar height
    */
   public int getGanttBarHeight()
   {
      return (m_ganttBarHeight);
   }
   
   /**
    * Retrieve a flag indicating if a separator is shown between the
    * major and minor scales.
    * 
    * @return boolean flag
    */
   public boolean getTimescaleSeparator()
   {
      return (m_timescaleSeparator);
   }

   /**
    * Retrieves a timescale tier
    * 
    * @return timescale tier
    */   
   public TimescaleTier getTimescaleTopTier()
   {
      return (m_timescaleTopTier);
   }
   
   /**
    * Retrieves a timescale tier
    * 
    * @return timescale tier
    */   
   public TimescaleTier getTimescaleMiddleTier()
   {
      return (m_timescaleMiddleTier);
   }

   /**
    * Retrieves a timescale tier
    * 
    * @return timescale tier
    */   
   public TimescaleTier getTimescaleBottomTier()
   {
      return (m_timescaleBottomTier);
   }
   
   /**
    * Retrieve the timescale size value. This is a percentage value.
    * 
    * @return timescale size value
    */
   public int getTimescaleSize()
   {
      return (m_timescaleSize);
   }
   
   /**
    * Retrieve the non-working time color.
    * 
    * @return non-working time color
    */
   public ColorType getNonWorkingColor()
   {
      return (m_nonWorkingColor);
   }
   
   /**
    * Retrieve the non-working time pattern. This is an integer between
    * 0 and 10 inclusive which represents the fixed set of patterns
    * supported by MS Project.
    * 
    * @return non-working time pattern
    */
   public int getNonWorkingPattern()
   {
      return (m_nonWorkingPattern);
   }
   
   /**
    * Retrieve the style used to draw non-working time.
    * 
    * @return non working time style
    */
   public NonWorkingTimeStyle getNonWorkingStyle()
   {
      return (m_nonWorkingStyle);      
   }
   
   /**
    * Retrieve the always rollup Gantt bars flag.
    * 
    * @return always rollup Gantt bars flag
    */
   public boolean getAlwaysRollupGanttBars()
   {
      return (m_alwaysRollupGanttBars);
   }

   /**
    * Retrieve the bar date format.
    * 
    * @return bar date format
    */
   public int getBarDateFormat()
   {
      return (m_barDateFormat);
   }

   /**
    * Retrieve the hide rollup bars when summary expanded
    * 
    * @return hide rollup bars when summary expanded
    */
   public boolean getHideRollupBarsWhenSummaryExpanded()
   {
      return (m_hideRollupBarsWhenSummaryExpanded);
   }

   /**
    * Retrieve the bar link style.
    * 
    * @return bar link style
    */
   public LinkStyle getLinkStyle()
   {
      return (m_linkStyle);
   }
   
   /**
    * Retrieve the round bars to whole days flag.
    * 
    * @return round bars to whole days flag
    */
   public boolean getRoundBarsToWholeDays()
   {
      return (m_roundBarsToWholeDays);
   }

   /**
    * Retrieve the show bar splits flag.
    * 
    * @return show bar splits flag
    */
   public boolean getShowBarSplits()
   {
      return (m_showBarSplits);
   }
   
   /**
    * Retrieve the show drawings flag
    * 
    * @return show drawings flag
    */
   public boolean getShowDrawings()
   {
      return (m_showDrawings);
   }
   
   /**
    * Retrieve an array reprtesenting bar styles which have been defined
    * by the user for a specific task.
    * 
    * @return array of bar style exceptions
    */
   public GanttBarStyleException[] getBarStyleExceptions()
   {
      return m_barStyleExceptions;
   }
   
   /**
    * Retrieve an array of bar styles which are applied to all Gantt
    * chart bars, unless an exception has been defined.
    * 
    * @return array of bar styles
    */
   public GanttBarStyle[] getBarStyles()
   {
      return m_barStyles;
   }

   /**
    * Retrieve the width ofthe table part of the view.
    * 
    * @return table width
    */
   public int getTableWidth ()
   {
      return (m_tableWidth);
   }

   /**
    * Retrieve the name of the table part of the view.
    * 
    * @return table name
    */
   public String getTableName ()
   {
      return (m_tableName);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */
   public FontStyle getBarTextBottomFontStyle()
   {
      return (m_barTextBottomFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getBarTextInsideFontStyle()
   {
      return (m_barTextInsideFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getBarTextLeftFontStyle()
   {
      return (m_barTextLeftFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getBarTextRightFontStyle()
   {
      return (m_barTextRightFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getBarTextTopFontStyle()
   {
      return (m_barTextTopFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getCriticalTasksFontStyle()
   {
      return (m_criticalTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getExternalTasksFontStyle()
   {
      return (m_externalTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getHighlightedTasksFontStyle()
   {
      return (m_highlightedTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getMajorTimescaleFontStyle()
   {
      return (m_majorTimescaleFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getMarkedTasksFontStyle()
   {
      return (m_markedTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getMilestoneTasksFontStyle()
   {
      return (m_milestoneTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getMinorTimescaleFontStyle()
   {
      return (m_minorTimescaleFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getNonCriticalTasksFontStyle()
   {
      return (m_nonCriticalTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getProjectSummaryTasksFontStyle()
   {
      return (m_projectSummaryTasksFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getRowAndColumnFontStyle()
   {
      return (m_rowAndColumnFontStyle);
   }
   
   /**
    * Retrieve a FontStyle instance.
    * 
    * @return FontStyle instance
    */   
   public FontStyle getSummaryTasksFontStyle()
   {
      return (m_summaryTasksFontStyle);
   }
   
   /**
    * Retrieve an instance of the Table class representing the
    * table part of this view.
    * 
    * @return table instance
    */
   public Table getTable ()
   {
      return (m_parent.getTaskTableByName(m_tableName));
   }
   
   /**
    * This method maps the encoded height of a Gantt bar to
    * the height in pixels.
    * 
    * @param height encoded height
    * @return height in pixels
    */
   private int mapGanttBarHeight (int height)
   {
      switch (height)
      {
         case 0:
         {
            height = 6;
            break;
         }

         case 1:
         {
            height = 8;
            break;
         }

         case 2:
         {
            height = 10;
            break;
         }

         case 3:
         {
            height = 12;
            break;
         }
         
         case 4:
         {
            height = 14;
            break;
         }
         
         case 5:
         {
            height = 18;
            break;
         }
         
         case 6:
         {
            height = 24;
            break;
         }         
      }
      
      return (height);
   }
   
   /**
    * Retrieve font details from a block of property data.
    * 
    * @param data property data
    * @param offset offset into property data
    * @return FontStyle instance
    */
   private FontStyle getFontStyle (byte[] data, int offset)
   {
      Integer index = new Integer(MPPUtility.getByte(data, offset));
      FontBase fontBase = m_parent.getFontBase(index);
      int style = MPPUtility.getByte(data, offset+1);
      ColorType color = ColorType.getInstance(MPPUtility.getByte(data, offset+2));
      
      boolean bold = ((style & 0x01) != 0);
      boolean italic = ((style & 0x02) != 0);
      boolean underline = ((style & 0x04) != 0);
      
      return (new FontStyle (fontBase, italic, bold, underline, color));
   }
   
   /**
    * Generate a string representation of this instance.
    * 
    * @return string representation of this instance
    */   
   public String toString ()
   {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      PrintWriter pw = new PrintWriter (os);
      pw.println ("[GanttChartView");
      pw.println ("   " + super.toString());

      pw.println ("   highlightedTasksFontStyle=" + m_highlightedTasksFontStyle);
      pw.println ("   rowAndColumnFontStyle=" + m_rowAndColumnFontStyle);
      pw.println ("   nonCriticalTasksFontStyle=" + m_nonCriticalTasksFontStyle);
      pw.println ("   criticalTasksFontStyle=" + m_criticalTasksFontStyle);
      pw.println ("   summaryTasksFontStyle=" + m_summaryTasksFontStyle);
      pw.println ("   milestoneTasksFontStyle=" + m_milestoneTasksFontStyle);
      pw.println ("   majorTimescaleFontStyle=" + m_majorTimescaleFontStyle);
      pw.println ("   minorTimescaleFontStyle=" + m_minorTimescaleFontStyle);
      pw.println ("   barTextLeftFontStyle=" + m_barTextLeftFontStyle);
      pw.println ("   barTextRightFontStyle=" + m_barTextRightFontStyle);
      pw.println ("   barTextTopFontStyle=" + m_barTextTopFontStyle);
      pw.println ("   barTextBottomFontStyle=" + m_barTextBottomFontStyle);
      pw.println ("   barTextInsideFontStyle=" + m_barTextInsideFontStyle);
      pw.println ("   markedTasksFontStyle=" + m_markedTasksFontStyle);
      pw.println ("   projectSummaryTasksFontStyle=" + m_projectSummaryTasksFontStyle);
      pw.println ("   externalTasksFontStyle=" + m_externalTasksFontStyle);
      
      pw.println ("   SheetRowsGridLines=" + m_sheetRowsGridLines);
      pw.println ("   SheetColumnsGridLines=" + m_sheetColumnsGridLines);
      pw.println ("   TitleVerticalGridLines=" + m_titleVerticalGridLines);
      pw.println ("   TitleHorizontalGridLines=" + m_titleHorizontalGridLines);
      pw.println ("   MajorColumnsGridLines=" + m_majorColumnsGridLines);
      pw.println ("   MinorColumnsGridLines=" + m_minorColumnsGridLines);
      pw.println ("   GanttRowsGridLines=" + m_ganttRowsGridLines);
      pw.println ("   BarRowsGridLines=" + m_barRowsGridLines);
      pw.println ("   CurrentDateGridLines=" + m_currentDateGridLines);
      pw.println ("   PageBreakGridLines=" + m_pageBreakGridLines);
      pw.println ("   ProjectStartGridLines=" + m_projectStartGridLines);
      pw.println ("   ProjectFinishGridLines=" + m_projectFinishGridLines);
      pw.println ("   StatusDateGridLines=" + m_statusDateGridLines);  
      pw.println ("   GanttBarHeight=" + m_ganttBarHeight);      
      pw.println ("   TimescaleTopTier=" + m_timescaleTopTier);      
      pw.println ("   TimescaleMiddleTier=" + m_timescaleMiddleTier);
      pw.println ("   TimescaleBottomTier=" + m_timescaleBottomTier);      
      pw.println ("   TimescaleSeparator=" + m_timescaleSeparator);      
      pw.println ("   TimescaleSize=" + m_timescaleSize + "%");      
      pw.println ("   NonWorkingDaysCalendarName=" + m_nonWorkingDaysCalendarName);      
      pw.println ("   NonWorkingColor=" + m_nonWorkingColor);            
      pw.println ("   NonWorkingPattern=" + m_nonWorkingPattern);                  
      pw.println ("   NonWorkingStyle=" + m_nonWorkingStyle);                        
      pw.println ("   ShowDrawings=" + m_showDrawings);
      pw.println ("   RoundBarsToWholeDays=" + m_roundBarsToWholeDays);
      pw.println ("   ShowBarSplits=" + m_showBarSplits);
      pw.println ("   AlwaysRollupGanttBars=" + m_alwaysRollupGanttBars);
      pw.println ("   HideRollupBarsWhenSummaryExpanded=" + m_hideRollupBarsWhenSummaryExpanded);      
      pw.println ("   BarDateFormat=" + m_barDateFormat);
      pw.println ("   LinkStyle=" + m_linkStyle);      
      pw.println ("   TableWidth=" + m_tableWidth);      
      pw.println ("   TableName=" + m_tableName);      
      pw.println ("   Table=" + getTable());
      
      for (int loop=0; loop < m_barStyles.length; loop++)
      {
         pw.println ("   BarStyle=" + m_barStyles[loop]);               
      }

      if (m_barStyleExceptions != null)
      {
         for (int loop=0; loop < m_barStyleExceptions.length; loop++)
         {
            pw.println ("   BarStyleException=" + m_barStyleExceptions[loop]);               
         }
      }
      
      pw.println ("]");
      pw.flush();
      return (os.toString());
   }
   
   private MPPFile m_parent;
   private GridLines m_sheetRowsGridLines;
   private GridLines m_sheetColumnsGridLines;
   private GridLines m_titleVerticalGridLines;
   private GridLines m_titleHorizontalGridLines;
   private GridLines m_majorColumnsGridLines;
   private GridLines m_minorColumnsGridLines;
   private GridLines m_ganttRowsGridLines;
   private GridLines m_barRowsGridLines;
   private GridLines m_currentDateGridLines;
   private GridLines m_pageBreakGridLines;
   private GridLines m_projectStartGridLines;
   private GridLines m_projectFinishGridLines;
   private GridLines m_statusDateGridLines;

   private int m_ganttBarHeight;

   private TimescaleTier m_timescaleTopTier;   
   private TimescaleTier m_timescaleMiddleTier;
   private TimescaleTier m_timescaleBottomTier;      
   private boolean m_timescaleSeparator;
   private int m_timescaleSize;

   private String m_nonWorkingDaysCalendarName;
   private ColorType m_nonWorkingColor;
   private int m_nonWorkingPattern;
   private NonWorkingTimeStyle m_nonWorkingStyle;

   private boolean m_showDrawings;
   private boolean m_roundBarsToWholeDays;
   private boolean m_showBarSplits;
   private boolean m_alwaysRollupGanttBars;
   private boolean m_hideRollupBarsWhenSummaryExpanded;
   private int m_barDateFormat;
   private LinkStyle m_linkStyle;
   
   private GanttBarStyle[] m_barStyles;
   private GanttBarStyleException[] m_barStyleExceptions;
   
   private int m_tableWidth;
   private String m_tableName;

   private FontStyle m_highlightedTasksFontStyle;
   private FontStyle m_rowAndColumnFontStyle;   
   private FontStyle m_nonCriticalTasksFontStyle;
   private FontStyle m_criticalTasksFontStyle;
   private FontStyle m_summaryTasksFontStyle;   
   private FontStyle m_milestoneTasksFontStyle;   
   private FontStyle m_majorTimescaleFontStyle;
   private FontStyle m_minorTimescaleFontStyle;   
   private FontStyle m_barTextLeftFontStyle;
   private FontStyle m_barTextRightFontStyle;
   private FontStyle m_barTextTopFontStyle;
   private FontStyle m_barTextBottomFontStyle;
   private FontStyle m_barTextInsideFontStyle;
   private FontStyle m_markedTasksFontStyle;
   private FontStyle m_projectSummaryTasksFontStyle;   
   private FontStyle m_externalTasksFontStyle;
   
   private static final Integer PROPERTIES = new Integer (1);
   private static final Integer VIEW_PROPERTIES = new Integer (574619656);
   private static final Integer TOP_TIER_PROPERTIES = new Integer (574619678);      
   private static final Integer BAR_PROPERTIES = new Integer (574619661);
   private static final Integer TABLE_PROPERTIES = new Integer (574619655);
   private static final Integer TABLE_NAME = new Integer (574619658);
}